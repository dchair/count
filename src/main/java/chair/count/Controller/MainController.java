package chair.count.Controller;

import chair.count.Model.PlayerModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {


    @GetMapping("/index")
    public String index(Model model){

        return "index";
    }
}
