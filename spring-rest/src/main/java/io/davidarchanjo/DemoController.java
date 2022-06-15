package io.davidarchanjo;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;


@Data
class UserDTO {
    private long id;
}

@RestController
@RequestMapping("spring-rest")
public class DemoController {

    @GetMapping("{id:[\\d]+}")
    public String get() {
        return "get";
    }

    @GetMapping(params = "id")
    public String getx(UserDTO user) {
        return user.toString();
    }

    @PostMapping
    public String post() {
        return "post";
    }

    @PutMapping
    public String put() {
        return "put";
    }

    @DeleteMapping
    public String delete() {
        return "delete";
    }

    @RequestMapping(value = "/ex/foos", headers = { "key1=val1", "key2=val2" }, method = GET)
    public String getFoosWithHeader() {
        return "Get some Foos with Header";
    }

    @RequestMapping(value = "/ex/foos", headers = "Accept=application/json", method = GET)
    public String getFoosAsJsonFromBrowser() {
        return "Get some Foos with Header Old";
    }

    @RequestMapping(value = "/ex/foos/{id:[\\d]+}", method = GET)
    public String getFoosBySimplePathWithPathVariable(@PathVariable String id) {
        return "Get a specific Foo with id=" + id;
    }

    @RequestMapping(value = "/ex/bars", params = "id", method = GET)
    public String getBarBySimplePathWithExplicitRequestParam(@RequestParam long id) {
        return "Get a specific Bar with id=" + id;
    }

}