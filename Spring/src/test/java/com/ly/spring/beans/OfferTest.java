package com.ly.spring.beans;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 9:18 2018/10/19
 * @Modified By:
 */
public class OfferTest {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void testPersonal() {
        Personal personal = (Personal) ioc.getBean("personal3");
        System.out.println(personal);
    }

    @Test
    public void testCompany() {
        Company company = (Company) ioc.getBean("company");
        System.out.println(company);
    }

    @Test
    public void testOffer() {
        Offer offer = (Offer) ioc.getBean("offer");
        System.out.println(offer);
    }
}
