package personal.cyy.automall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import personal.cyy.automall.constant.TemplateNameConstant;

/**
 * @Author Cinyky
 * @Date 11:53 2019-05-15
 */

@Controller
public class IndexController extends IController {


    @RequestMapping("/index")
    public String template(Model model) {
        return TemplateNameConstant.INDEX;
    }


    @RequestMapping("/typography")
    public String typography(Model model) {
        return TemplateNameConstant.TYPOGRAPHY;
    }


    @RequestMapping("/dropdown-toggle")
    public String dropdownToggle(Model model) {
        return TemplateNameConstant.INDEX;
    }


    @RequestMapping("/elements")
    public String elements(Model model) {
        return TemplateNameConstant.ELEMENTS;
    }


    @RequestMapping("/buttons")
    public String buttons(Model model) {
        return TemplateNameConstant.BUTTONS;
    }


    @RequestMapping("/treeview")
    public String treeview(Model model) {
        return TemplateNameConstant.TREEVIEW;
    }


    @RequestMapping("/jquery-ui")
    public String jqueryUi(Model model) {
        return TemplateNameConstant.JQUERY_UI;
    }


    @RequestMapping("/nestable-list")
    public String nestableList(Model model) {
        return TemplateNameConstant.NESTABLE_LIST;
    }


    @RequestMapping("/tables")
    public String tables(Model model) {
        return TemplateNameConstant.TABLES;
    }


    @RequestMapping("/jqgrid")
    public String jqgrid(Model model) {
        return TemplateNameConstant.JQGRID;
    }

    @RequestMapping("/icon-edit")
    public String iconEdit(Model model) {
        return TemplateNameConstant.ICON_EDIT;
    }

    @RequestMapping("/form-elements")
    public String formElements(Model model) {
        return TemplateNameConstant.FORM_ELEMENTS;
    }

    @RequestMapping("/form-wizard")
    public String formWizard(Model model) {
        return TemplateNameConstant.FORM_WIZARD;
    }

    @RequestMapping("/wysiwyg")
    public String wysiwyg(Model model) {
        return TemplateNameConstant.WYSIWYG;
    }

    @RequestMapping("/dropzone")
    public String dropzone(Model model) {
        return TemplateNameConstant.DROPZONE;
    }

    @RequestMapping("/widgets")
    public String widgets(Model model) {
        return TemplateNameConstant.WIDGETS;
    }

    @RequestMapping("/calendar")
    public String calendar(Model model) {
        return TemplateNameConstant.CALENDAR;
    }

    @RequestMapping("/gallery")
    public String gallery(Model model) {
        return TemplateNameConstant.GALLERY;
    }

    @RequestMapping("/profile")
    public String profile(Model model) {
        return TemplateNameConstant.PROFILE;
    }

    @RequestMapping("/inbox")
    public String inbox(Model model) {
        return TemplateNameConstant.INBOX;
    }

    @RequestMapping("/pricing")
    public String pricing(Model model) {
        return TemplateNameConstant.PRICING;
    }

    @RequestMapping("/timeline")
    public String timeline(Model model) {
        return TemplateNameConstant.TIMELINE;
    }

    @RequestMapping("/login")
    public String login(Model model) {
        return TemplateNameConstant.LOGIN;
    }

    @RequestMapping("/error/404")
    public String error_404(Model model) {
        return TemplateNameConstant.ERROR_404;
    }

    @RequestMapping("/error/500")
    public String error_500(Model model) {
        return TemplateNameConstant.ERROR_500;
    }

    @RequestMapping("/faq")
    public String faq(Model model) {
        return TemplateNameConstant.FAQ;
    }


}
