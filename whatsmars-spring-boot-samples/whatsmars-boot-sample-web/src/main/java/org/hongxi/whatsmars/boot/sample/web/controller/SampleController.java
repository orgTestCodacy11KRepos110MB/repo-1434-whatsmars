package org.hongxi.whatsmars.boot.sample.web.controller;

import org.hongxi.whatsmars.boot.sample.web.model.User;
import org.hongxi.whatsmars.common.result.Result;
import org.hongxi.whatsmars.common.result.ResultHelper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

/**
 * Created by shenhongxi on 2020/8/16.
 */
@Validated
@RestController
@RequestMapping("/sample")
public class SampleController {

    @GetMapping({"/hey", "hi"})
    public Result<String> hello(@RequestParam String userId,
                                @RequestParam @Min(value = 18) Integer age) {
        String hello = userId + "," + age;
        return ResultHelper.newSuccessResult(hello);
    }

    @GetMapping("/hello")
    public Result<String> helloGet(@RequestParam String userId) {
        return ResultHelper.newSuccessResult(userId);
    }

    @PostMapping("/hello")
    public Result<String> helloPost(@RequestParam String userId) {
        return ResultHelper.newSuccessResult(userId);
    }

    @PostMapping("/hello2")
    public Result<User> hello2(@RequestBody User user) {
        return ResultHelper.newSuccessResult(user);
    }

    @GetMapping("/hello3")
    public Result<String> hello3(String name) {
        return ResultHelper.newSuccessResult("Hello, " + name);
    }

    @GetMapping("/hello/{name}")
    public Result<String> hello4(@PathVariable String name) {
        return ResultHelper.newSuccessResult("Hello, " + name);
    }
}
