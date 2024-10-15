package com.nt.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.dto.Device;
import com.nt.service.DeviceServiceImpl;

@Controller
@SessionAttributes("device")
public class DeviceController {

	private final DeviceServiceImpl deviceService;

	@Autowired
	public DeviceController(DeviceServiceImpl deviceService) {
		this.deviceService = deviceService;
	}

	// Mapping for displaying the update form
	@GetMapping("/update")
	public String showUpdateForm(Model model) {
		if (!model.containsAttribute("device")) {
			model.addAttribute("device", new Device());
		}
		return "update";
	}

	// Mapping for displaying the search form
	@RequestMapping("/search")
	public String showSearchForm(Model model) {
		if (!model.containsAttribute("device")) {
			model.addAttribute("device", new Device());
		}
		return "search";
	}

	// Mapping for displaying the insert form
	@GetMapping("/insert")
	public String showInsertForm(Model model) {
		if (!model.containsAttribute("device")) {
			model.addAttribute("device", new Device());
		}
		return "insert";
	}

	@GetMapping("/DSucess")
	public String showSuccessPage() {
		return "DSucess";
	}

	// Mapping for displaying the delete form
	@GetMapping("/delete")
	public String showDeleteForm(Model model) {
		if (!model.containsAttribute("device")) {
			model.addAttribute("device", new Device());
		}
		return "delete";
	}

	@GetMapping("/DError")
	public String DErrorPage() {
		return "DError";
	}

	@PostMapping("/search")
	public String search(@Valid @ModelAttribute("device") Device dev, BindingResult result,
			RedirectAttributes redirectAttributes, Model model) {
		if (result.hasErrors()) {
			// There are validation errors, return to the search form with error messages
			return "search"; // Assuming the view name is "search.jsp"
		}
		// Validation passed, proceed with the search operation
		List<Device> devices = deviceService.searchDeviceByName(dev.getName());
		if (!devices.isEmpty()) {
			model.addAttribute("device", devices.get(0)); // Add the entire device object to the model
			redirectAttributes.addFlashAttribute("message", "Device '" + dev.getName() + "' found ");
			return "redirect:/DSucess";
		} else {
			redirectAttributes.addFlashAttribute("message", "Device '" + dev.getName() + "' not found");
			return "redirect:/DError?notFound=true";
		}
	}

	@PostMapping("/insert")
	public String insert(@Valid @ModelAttribute("device") Device dev, RedirectAttributes redirectAttributes,
			Model model, BindingResult result) {
		if (result.hasErrors()) {
			// There are validation errors, return to the insert form with error messages
			return "insert"; // Assuming the view name is "insert.jsp"
		}

		// Validation passed, proceed with the insert operation
		List<Device> devices = deviceService.searchDeviceByName(dev.getName());

		if (devices.isEmpty()) {
			// If the device doesn't exist, insert it
			deviceService.insert(dev, dev.getName(), dev.getCount());
			model.addAttribute("name", dev.getName());
			model.addAttribute("count", dev.getCount());
			redirectAttributes.addFlashAttribute("message", "Device '" + dev.getName() + "' inserted ");
			return "redirect:/DSucess";
		} else {
			model.addAttribute("name", dev.getName());
			model.addAttribute("count", devices.get(0).getCount());
			redirectAttributes.addFlashAttribute("message", "Device '" + dev.getName() + "' not insert ");
			return "redirect:/DError?notFound=true";
		}
	}

	@PostMapping("/delete")
	public String delete(@Valid @ModelAttribute("device") Device dev, RedirectAttributes redirectAttributes,
			Model model, BindingResult result) {

		if (result.hasErrors()) {
			// There are validation errors, return to the delete form with error messages
			return "delete"; // Assuming the view name is "delete.jsp"
		}

		// Validation passed, proceed with the delete operation
		List<Device> devices = deviceService.searchDeviceByName(dev.getName());

		if (!devices.isEmpty()) {
			model.addAttribute("name", dev.getName());
			model.addAttribute("count", devices.get(0).getCount());
			deviceService.delete(dev.getName());
			redirectAttributes.addFlashAttribute("message", "Device '" + dev.getName() + "' deleted ");
			return "redirect:/DSucess";
		} else {
			redirectAttributes.addFlashAttribute("message", "Device '" + dev.getName() + "' not deleted ");
			return "redirect:/DError?notFound=true";
		}
	}

	@PostMapping("/update")
	public String update(@Valid @ModelAttribute("device") Device dev, RedirectAttributes redirectAttributes,
			Model model, BindingResult result) {
		if (result.hasErrors()) {
			// There are validation errors, return to the update form with error messages
			return "update"; // Assuming the view name is "update.jsp"
		}

		// Validation passed, proceed with the update operation
		List<Device> devices = deviceService.update(dev.getName(), dev.getCount());

		if (!devices.isEmpty()) {
			model.addAttribute("name", dev.getName());
			model.addAttribute("count", devices.get(0).getCount());
			redirectAttributes.addFlashAttribute("message", "Device '" + dev.getName() + "' updated ");
			return "redirect:/DSucess";
		} else {
			redirectAttributes.addFlashAttribute("message", "Device '" + dev.getName() + "' not updated ");
			return "redirect:/DError?notFound=true";
		}
	}

}
