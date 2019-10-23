/*
 * Copyright (C) 2019 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.xuexiang.imageprocess.fragment;

import com.xuexiang.imageprocess.fragment.opencv.OpenCVBasicFragment;
import com.xuexiang.imageprocess.fragment.opencv.OpenCVImgProcFragment;
import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xpage.base.XPageContainerListFragment;

/**
 * @author xuexiang
 * @since 2019-09-25 10:51
 */
@Page(name = "OpenCV图像处理")
public class OpenCVFragment extends XPageContainerListFragment {
    /**
     * 获取页面的类集合[使用@Page注解进行注册的页面]
     *
     * @return
     */
    @Override
    protected Class[] getPagesClasses() {
        return new Class[] {
                OpenCVBasicFragment.class,
                OpenCVImgProcFragment.class
        };
    }
}
