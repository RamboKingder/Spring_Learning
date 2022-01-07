package com.lxl.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxl.domain.User;
import com.lxl.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/get10")
    @ResponseBody // 表示不进行页面跳转
    public void getParams10(String username, MultipartFile uploadFile1, MultipartFile uploadFile2) throws IOException {
        System.out.println(username);
        System.out.println(uploadFile1);

        String originalFilename1 = uploadFile1.getOriginalFilename(); // 这才是真正的文件名
        uploadFile1.transferTo(new File("D:\\" + originalFilename1));
        System.out.println(uploadFile2);
        String originalFilename2 = uploadFile2.getOriginalFilename(); // 这才是真正的文件名
        uploadFile2.transferTo(new File("D:\\" + originalFilename2));
    }

    @RequestMapping("/get9")
    @ResponseBody // 表示不进行页面跳转
    public void getParams9(@CookieValue(value = "JSESSIONID", required = false) String jsessionId){
        System.out.println(jsessionId);
    }

    @RequestMapping("/get8")
    @ResponseBody // 表示不进行页面跳转
    public void getParams8(@RequestHeader(value = "User-Agent", required = false) String userAgent){
        System.out.println(userAgent);
    }

    @RequestMapping("/get7")
    @ResponseBody // 表示不进行页面跳转
    public void getParams7(Date date){
        System.out.println(date);
    }

    // 使用restful风格获取请求参数
    // http://localhost:8080/Spring_05_mvc_war/user/userRestful/LongXiaolan
    @RequestMapping(value = "/userRestful/{username}", method = RequestMethod.POST)
    @ResponseBody // 表示不进行页面跳转
    public void getRestfulParams(@PathVariable(value="username", required = true) String username){
        System.out.println(username);
    }

    // 参数绑定：前端请求参数名与后台处理方法的参数名不一致时
    // 就要在后台处理方法的参数前面加上参数绑定，将其与前端提交的参数名绑定起来
    @RequestMapping("/get6")
    @ResponseBody // 表示不进行页面跳转
    public void getParams6(@RequestParam(value="user", defaultValue = "LongXiaolan") String username){
        System.out.println(username);
    }

    // 通过http://localhost:8080/Spring_05_mvc_war/ajax.jsp提交的请求
    @RequestMapping("/get5")
    @ResponseBody
    public void getParams5(@RequestBody(required = false) List<User> userList){
        System.out.println(userList);
    }

    // 通过http://localhost:8080/Spring_05_mvc_war/form.jsp提交的请求
    @RequestMapping("/get4")
    @ResponseBody // 表示不进行页面跳转
    public void getParams4(VO vo){
        System.out.println(vo);
    }

    // url栏输入：http://localhost:8080/Spring_05_mvc_war/user/get3?strs=Alice&strs=Bob&strs=David
    @RequestMapping("/get3")
    @ResponseBody // 表示不进行页面跳转
    public void getParams3(String[] strs){
        System.out.println(Arrays.toString(strs));
    }

    @RequestMapping("/get2")
    @ResponseBody // 表示不进行页面跳转
    public void getParams2(User user){
        System.out.println(user);
    }

    @RequestMapping("/get")
    @ResponseBody // 表示不进行页面跳转
    public void getParams(String username, int age){
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping("/resp4")
    @ResponseBody
    public User testResponse4(){
        User user = new User();
        user.setUsername("LongXiaolan");
        user.setAge(21);
        return user;
    }

    @RequestMapping("/resp3")
    @ResponseBody
    public String testResponse3() throws JsonProcessingException {
        User user = new User();
        user.setUsername("LongXiaolan");
        user.setAge(21);
        // 使用json的转换工具jackson将对象转换成字符串再返回
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(user);

        return result;
    }

    @RequestMapping("/resp2")
    @ResponseBody // 如果这里不加@ResponseBody，DispatcherServlet会去找我返回的字符串对应的视图
    public String testResponse2(){
        return "加上@ResponseBody注解可以告诉SpringMVC我需要的不是页面跳转";
    }

    @RequestMapping("/resp1")
    public void testResponse(HttpServletResponse resp) throws IOException {
        // resp.setContentType("text/html;charset=UTF-8");
        // resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("我通过HttpServletResponse resp.getWriter().write()方法写了这句话");
    }

    @RequestMapping("/mav2")
    public ModelAndView testMAV2(ModelAndView mav){
        mav.addObject("username", "传参的ModelAndView");
        mav.setViewName("/success.jsp");
        return mav;
    }

    @RequestMapping("/mav")
    public ModelAndView testMAV(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("username", "LongXiaolan");
        mav.setViewName("/success.jsp"); // 设置视图名称
        return mav;
    }

    // 如果要在浏览器访问：需要在url后面补上user/success?username=xxx...
    @RequestMapping(value = "/success", params = {"username"})
    public String success(){
        // 加/代表从当前web应用下找资源
        // 不加/代表从http://localhost:8080/Spring_05_mvc_war/user下找资源
        return "redirect:/success.jsp"; // forward:表示请求转发，redirect:表示重定向
    }
}
