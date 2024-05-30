package org.example.kursovabd.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class UserController {
//    private UserService cs;
//    @RequestMapping("/Users")
//    public String showUsers(Model model) {
//        model.addAttribute("UsersList", cs.getUsers());
//        cs.getUsers().forEach(c -> System.out.println(c.toString()));
//
//        return "Users";
//    }


//    @PostMapping()
//    public String add_date(@RequestParam int id,int firstid, int secondid, int country, Model model){
//        model.addAttribute("Userinfo",cs.getUserInfo(id));
//        return "User_info";
//    }

//    @RequestMapping("/register")
//    public String addUser
//            (@RequestParam String login, @RequestParam String password, @RequestParam String email,Model model) {
//        model.addAttribute("UsersList", cs.getUsers());
//        cs.getUsers().forEach(c -> System.out.println(c.toString()));
//
//        return "Users";
//    }
//
//    @PostMapping()
//    public String add_date(@RequestParam int id,int firstid, int secondid, int country, Model model){
//        model.addAttribute("Userinfo",cs.getUserInfo(id));
//        return "User_info";
//    }
//
//    @GetMapping()
//    public String add_date(@RequestParam int id,int firstid, int secondid, int country, Model model){
//        model.addAttribute("Userinfo",cs.getUserInfo(id));
//        return "User_info";
//    }
//    private void addUser(MyUserRepository MyUserRepository){
//        MyUserRepository.addUser(new User("111", "11", "1"));
//    }

//
//@Override
//public List<User> Read() {
//    List<User> User_list = new ArrayList<>();
//    try {
//        Statement statement = connection.creatUserment();
//        String SQL = "SELECT * FROM User";
//        ResultSet resultSet = statement.executeQuery(SQL);
//        while (resultSet.next()) {
//            User User = new User();
//            User.setId(resultSet.getInt("id"));
//            User.setSellerId(resultSet.getInt("seller_id"));
//            User.setTitle(resultSet.getString("title"));
//            User.setCost(resultSet.getInt("cost"));
//            User.setType(resultSet.getInt("type"));
//            User.setLocality(resultSet.getInt("locality"));
//            User.setCity(resultSet.getInt("city"));
//            User.setArea(resultSet.getInt("area"));
//            User.setBedrooms(resultSet.getInt("bedrooms"));
//            User.setFloors(resultSet.getInt("floors"));
//            User.setDateCreated(resultSet.getDate("date_created"));
//            User.setViewed(resultSet.getInt("viewed"));
//            User.setDeal(resultSet.getInt("deal"));
//            User.setArchived(resultSet.getInt("archived"));
//            User_list.add(User);
//        }
//    } catch (SQLException e) { throw new RuntimeException(e); }
//    return User_list;
//}





//    private final UserService UserService;
//    @RequestMapping("/showUsers")
//    public String showUsers(@RequestParam String color, Model model) {
//        model.addAttribute("user", "student");
//        model.addAttribute("color", color);
//        return "showUsers";
//    }

//    @GetMapping("/students")
//    public String viewStudents (Model model) {
//        var students = UserService.findAll();
//        model.addAttribute("students", students);
//        return "students";
//
//    }
//
//    @PostMapping("/add_student")
//
//    public String addStudent( @RequestParam String name, @RequestParam int age) {
//        UserService.addStudent(new Student(name, age));
//        return "redirect:/students";
//
//    }
}
