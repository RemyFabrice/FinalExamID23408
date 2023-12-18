package com.FinalProject.FExam.Controller;


import com.FinalProject.FExam.Model.Client;
import com.FinalProject.FExam.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClientController {

    @Autowired
  private ClientService clientService;
    @GetMapping("/saveClient")
    public String showApplicantForm(Model model) {
        model.addAttribute("Client", new Client());
        return "ClientAdd";
    }

    @PostMapping("/saveClient")
    public String saveApplicant(@ModelAttribute("Client") Client client , Model model) {

        Client savedClient = clientService.saveClient(client);



        clientService.saveClient(client);
        return "redirect:/ClientInformation";
    }
}
