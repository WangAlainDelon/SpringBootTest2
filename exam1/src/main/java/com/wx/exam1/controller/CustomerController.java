package com.wx.exam1.controller;

import com.alibaba.fastjson.JSON;
import com.wx.exam1.domain.Address;
import com.wx.exam1.domain.Customer;
import com.wx.exam1.service.AddressService;
import com.wx.exam1.service.CustomerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
    private static Short id = 0;
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AddressService addressService;

    /**
     * 传入first_name和last_name判断是否登陆成功
     * 不使用时候的curl请求：curl -X POST -d "first_name=MARY" -d "last_name=SMITH" 10.0.75.1:8080/v1/customer
     * 使用@RequestBody的curl请求，参数必须是json字符串：
     * curl -H "Accept: application/json" -H "Content-type: application/json" -X POST -d '{"first_name": "180000","last_name": "dvds"}'  http://10.0.75.1:8080/v1/customer
     *
     * @param customer
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> login(@Valid @RequestBody Customer customer) {
        Boolean login = customerService.login(customer);
        return ResponseEntity.ok("Login status ：" + login);
    }

    /**
     * 新增用户，/PUT 请求。通过curl 传入用户对象，包含first_name, last_name, email, address。
     * address 传入字符串， 必须是address 表中已经存在的地址。并将用户id返回。
     * 以前的curl请求： curl -v -X PUT -d "first_name=sdvsd" -d "last_name=nvjsdk" -d "address=47 MySakila Drive" 192.168.10.24:8080/adduser
     * 现在的curl请求： curl -X PUT --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"first_name": "sdvsd","last_name": "nvjsdk","email":"qq_email","address":"28 MySQL Boulevard"}'  http://10.0.75.1:8080/v1/customer
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<String> addUser(@Valid @RequestBody Customer customer) {
        Address addr = null;
        if (customer.getAddress() != null && customer.getAddress() != "") {
            addr = addressService.isAddr(customer.getAddress());
        }
        if (addr != null) {
            customer.setAddress_id(addr.getAddress_id());
            customerService.insertCustomer(customer);
            this.id = customer.getCustomer_id();
            return ResponseEntity.ok("New CustomerID：" + customer.getCustomer_id());
        }
        return ResponseEntity.status(500).body(null);
    }

    /**
     * 根据ID更新刚才的用户，/POST 请求。通过curl 传入修改过的用户对象。根据用户id修改用户，id为上一道题返回的用户。然后将更新后的用户数据返回。
     * 跟新的字段当然也只能是四个first_name, last_name, email, address。
     * 这个地址当然是address表中存在的地址，否则是不会更新用户的地址ID
     * 路径中要带上ID
     * curl命令： curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"first_name": "Mr","last_name": "Wang", "email":"vdsv","address":"125 Citt del Vaticano Boulevard"}'  http://10.0.75.1:8080/v1/customer/622
     */
    @RequestMapping(value = "{customer_id}", method = RequestMethod.POST)
    public ResponseEntity<String> uodateCustomer(@PathVariable("customer_id") Short customer_id, @RequestBody Customer customer, HttpServletResponse response) {
        if (customer_id == null) {
            customer.setCustomer_id(id);
        }
        customer.setCustomer_id(customer_id);
        Customer customerRe = customerService.update(customer);
        //将ID存于cookie
        Cookie cookie = new Cookie("customer_id", customer.getCustomer_id().toString());
        response.addCookie(cookie);
        return ResponseEntity.ok("The update was successful, and the result of the updated object was：" + customerRe.toString());
    }
    /**
     * 删除新增的用户，/DELETE 请求。其中用户的id为上一道题返回的id，然后通过cookie 发送给接口，后
     * 台使用HttpServlet 获取id。根据id删除用户。
     * 检测接口是否有数据，如果有则删除，那么需要写一个解析器，将cookie中的id绑定到实体的对象上去，
     * https://blog.csdn.net/qq_36922927/article/details/82057372
     * https://www.jianshu.com/p/0347bdde0c6d
     */
    //@DeleteMapping这个注解好像必须要带有参数才能访问到，这里通过注解获取Cookie

    /**
     * 这是以前的写法，如果不是删除数据，每次Cookie传过来的ID都要去查数据库看看是不是有这个用户，非常的繁琐
     * 绑定请求中的参数可以用在分布式中，比如token是在用户端携带过来的，客户端需要擦汗寻seeeion中的数据来比对
     * cookied,这个步骤可以直接写在参数解析绑定中。
     * curl命令：curl -X DELETE --header 'Content-Type: application/json' --header 'Accept: application/json' -b "customer_id=621"  http://10.0.75.1:8080/v1/customer
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<String> deletecustomerById(@CookieValue("customer_id") String customer_id) {
        System.out.println(customer_id);
        customerService.deleteById(Short.parseShort(customer_id));
        return ResponseEntity.ok("Successful deletion!!!");
    }

}
