package hello.springmvc.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class MappingController {

    @RequestMapping(value = "/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";

    }

    @RequestMapping(value = "/hello-get-v1", method = RequestMethod.GET)
    public String mappingV1() {
        log.info("mappingGetV1");
        return "ok";

    }

    /** * 편리한 축약 애노테이션 (코드보기)
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping("/hello-get-v2")
    public String mappingV2() {
        log.info("mappingGetV2");
        return "ok";

    }


    @GetMapping("/mapping/{userID}")
    public String mappingPath(@PathVariable("userID") String data) {
        log.info("maapingPath userID={}", data);
        return "ok";
    }


    @GetMapping("/mapping/{userID}/orders/{orderId}")
    public String mappingPath(@PathVariable("userID") String userId,
                              @PathVariable("orderId") String orderId) {

        log.info("maapingPath userID={}", userId);
        log.info("maapingPath orderID={}", orderId);

        return "ok";
    }



    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug" (! = )
     * 잘 사용안한다
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }






}
