package com.crud.rentalmobil.delivery.rest;

import com.crud.rentalmobil.model.DataMobil;
import com.crud.rentalmobil.repository.DataMobilRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
public class CrudController {

    private final DataMobilRepository dataMobilRepository;

    @Autowired
    public CrudController(DataMobilRepository dataMobilRepository) {
        this.dataMobilRepository = dataMobilRepository;
    }

    @GetMapping("/list-mobil")
    public String index(Model model) {
        String title_web = "List Mobil";
        model.addAttribute("title_web", title_web);
        model.addAttribute("items", dataMobilRepository.getAllDataMobil());
        return "list-mobil";
    }

    @GetMapping("/insert-mobil")
    public String addPersonForm(Model model) {
        String title_web = "Insert Mobil";
        model.addAttribute("title_web", title_web);
        model.addAttribute("mobil", new DataMobil());
        return "insert-mobil";
    }

    @PostMapping("/insert-mobil")
    public String addPerson(@ModelAttribute DataMobil dataMobil) {
        dataMobilRepository.insertDataMobil(dataMobil);
        return "redirect:/list-mobil";
    }

    @GetMapping("/edit-mobil/{id}")
    public String editPersonForm(@PathVariable Integer id, Model model) {
        String title_web = "Edit Mobil";
        model.addAttribute("title_web", title_web);
        DataMobil dataMobil = dataMobilRepository.findDataMobilBySeqId(id);
        model.addAttribute("mobil", dataMobil);
        return "edit-mobil";
    }

    @PostMapping("/edit-mobil/{id}")
    public String editPerson(@PathVariable Integer id, @ModelAttribute DataMobil dataMobil) {
        DataMobil dataMobilBySeqId = dataMobilRepository.findDataMobilBySeqId(id);
        if (dataMobilBySeqId != null) {
            dataMobilRepository.updateDataMobil(dataMobil);
        }
        return "redirect:/list-mobil";
    }

    @GetMapping("/delete-mobil/{id}")
    public String deleteMobil(@PathVariable Integer id, Model model) {
        model.addAttribute("seqId", id);
        return "confirm-delete";
    }

    @PostMapping("/delete-mobil/{id}")
    public String confirmDelete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        dataMobilRepository.deleteDataMobilBySeqId(id);
        redirectAttributes.addFlashAttribute("deleteSuccess", "Mobil berhasil dihapus.");
        return "redirect:/list-mobil";
    }



}