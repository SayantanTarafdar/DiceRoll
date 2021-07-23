/**
 *  Copyright 2005-2016 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package org.sayantan.assesment.DiceRoll;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.apache.cxf.jaxrs.validation.JAXRSBeanValidationInInterceptor;
import org.apache.cxf.jaxrs.validation.JAXRSBeanValidationOutInterceptor;
import org.apache.cxf.jaxrs.validation.ValidationExceptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@SpringBootApplication
public class SampleRestApplication {

    @Autowired
    private Bus bus;

    public static void main(String[] args) {
        SpringApplication.run(SampleRestApplication.class, args);
    }
 
//    @Bean
//    public Server rsServer() {
//        // setup CXF-RS
//        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
//        endpoint.setBus(bus);
//        endpoint.setServiceBeans(Arrays.<Object>asList(new DiceServiceImpl()));
//        endpoint.setAddress("/diceservice");
//        endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
//        return endpoint.create();
//    }
	  @Bean 
	  public DiceServiceImpl diceServiceImpl() {
		  return new DiceServiceImpl();
	  }
	  @Bean
	  public JacksonJsonProvider jacksonJsonProvider() {
		  return new JacksonJsonProvider();
	  }
	  @Bean  
	  public HibernateJpaSessionFactoryBean sessionFactory() {
	     return new HibernateJpaSessionFactoryBean();
	  }
	  @Bean
	  public DiceRollExceptionMapper diceRollExceptionMapper() {
		  return new DiceRollExceptionMapper();
	  }
	  @Bean
	  public ValidationExceptionMapper validationExceptionMapper() {
		  ValidationExceptionMapper exceptionMapper = new ValidationExceptionMapper();
		  exceptionMapper.setAddMessageToResponse(true);
		  
		  return exceptionMapper;
	  }
	  @Bean
	  public JAXRSBeanValidationInInterceptor  jaxRSBeanValidationInInterceptor() {
		  JAXRSBeanValidationInInterceptor inInterceptor=new JAXRSBeanValidationInInterceptor();
		  return inInterceptor;  
	  } 
	  @Bean
	  public JAXRSBeanValidationOutInterceptor   jaxRSBeanValidationOutInterceptor() {
		  return new JAXRSBeanValidationOutInterceptor ();  
	  } 
	  
}
