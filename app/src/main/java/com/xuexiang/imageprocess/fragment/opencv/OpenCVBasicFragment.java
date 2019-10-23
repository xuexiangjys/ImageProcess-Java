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

package com.xuexiang.imageprocess.fragment.opencv;

import com.xuexiang.xpage.annotation.Page;
import com.xuexiang.xpage.base.XPageSimpleListFragment;

import org.opencv.core.Core;

import java.util.List;

/**
 * @author xuexiang
 * @since 2019-09-25 11:00
 */
@Page(name = "OpenCV基础使用")
public class OpenCVBasicFragment extends XPageSimpleListFragment {
    /**
     * 初始化例子
     *
     * @param lists
     * @return
     */
    @Override
    protected List<String> initSimpleData(List<String> lists) {
        lists.add("OpenCV的版本:" + Core.getVersionString());
        return lists;
    }

    /**
     * 条目点击
     *
     * @param position
     */
    @Override
    protected void onItemClick(int position) {
        switch(position) {
            case 1:

                break;
            case 2:

                break;
            default:
                break;
        }
    }
}
