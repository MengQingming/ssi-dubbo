/*
 * Copyright 1999-2012 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hm.SSI.dubbo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hm.SSI.dubbo.api.AnnotationService;

/**
 * AnnotationAction
 * 
 * @author william.liangf
 */
@Component
public class AnnotationAction {
    
	@Autowired
    private AnnotationService annotationServiceImpl;
    
    public String doSayHello(String name) {
        return annotationServiceImpl.sayHello(name);
    }

}
