package org.example.kursovabd.controllers;

import lombok.AllArgsConstructor;
import org.example.kursovabd.Servises.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class ClientController {
    private ClientService cs;
    @RequestMapping("/clients")
    public String showClients(Model model) {
        model.addAttribute("clientsList", cs.getClients());
        cs.getClients().forEach(c -> System.out.println(c.toString()));

        return "clients";
    }


//    @PostMapping()
//    public String add_date(@RequestParam int id,int firstid, int secondid, int country, Model model){
//        model.addAttribute("clientinfo",cs.getClientInfo(id));
//        return "client_info";
//    }

//    @RequestMapping("/register")
//    public String addClient
//            (@RequestParam String login, @RequestParam String password, @RequestParam String email,Model model) {
//        model.addAttribute("clientsList", cs.getClients());
//        cs.getClients().forEach(c -> System.out.println(c.toString()));
//
//        return "clients";
//    }
//
//    @PostMapping()
//    public String add_date(@RequestParam int id,int firstid, int secondid, int country, Model model){
//        model.addAttribute("clientinfo",cs.getClientInfo(id));
//        return "client_info";
//    }
//
//    @GetMapping()
//    public String add_date(@RequestParam int id,int firstid, int secondid, int country, Model model){
//        model.addAttribute("clientinfo",cs.getClientInfo(id));
//        return "client_info";
//    }
//    private void addClient(ClientRepository clientRepository){
//        clientRepository.addClient(new Client("111", "11", "1"));
//    }

//
//@Override
//public List<Client> Read() {
//    List<Client> Client_list = new ArrayList<>();
//    try {
//        Statement statement = connection.creatClientment();
//        String SQL = "SELECT * FROM client";
//        ResultSet resultSet = statement.executeQuery(SQL);
//        while (resultSet.next()) {
//            Client Client = new Client();
//            Client.setId(resultSet.getInt("id"));
//            Client.setSellerId(resultSet.getInt("seller_id"));
//            Client.setTitle(resultSet.getString("title"));
//            Client.setCost(resultSet.getInt("cost"));
//            Client.setType(resultSet.getInt("type"));
//            Client.setLocality(resultSet.getInt("locality"));
//            Client.setCity(resultSet.getInt("city"));
//            Client.setArea(resultSet.getInt("area"));
//            Client.setBedrooms(resultSet.getInt("bedrooms"));
//            Client.setFloors(resultSet.getInt("floors"));
//            Client.setDateCreated(resultSet.getDate("date_created"));
//            Client.setViewed(resultSet.getInt("viewed"));
//            Client.setDeal(resultSet.getInt("deal"));
//            Client.setArchived(resultSet.getInt("archived"));
//            Client_list.add(Client);
//        }
//    } catch (SQLException e) { throw new RuntimeException(e); }
//    return Client_list;
//}





//    private final ClientService clientService;
//    @RequestMapping("/showClients")
//    public String showClients(@RequestParam String color, Model model) {
//        model.addAttribute("user", "student");
//        model.addAttribute("color", color);
//        return "showClients";
//    }

//    @GetMapping("/students")
//    public String viewStudents (Model model) {
//        var students = clientService.findAll();
//        model.addAttribute("students", students);
//        return "students";
//
//    }
//
//    @PostMapping("/add_student")
//
//    public String addStudent( @RequestParam String name, @RequestParam int age) {
//        clientService.addStudent(new Student(name, age));
//        return "redirect:/students";
//
//    }
}
