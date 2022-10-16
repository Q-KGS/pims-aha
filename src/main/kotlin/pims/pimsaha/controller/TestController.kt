package pims.pimsaha.controller

import org.apache.ibatis.session.SqlSession
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
class TestController {
    @Autowired
    private lateinit var sqlSession:SqlSession

    @GetMapping("/dbTest")
    fun test(model:Model, request:HttpServletRequest):String {
        val test:List<HashMap<String, String>> = sqlSession.selectList("test.first", null)
        println(test[0].toString())
        return test.toString()
    }
}