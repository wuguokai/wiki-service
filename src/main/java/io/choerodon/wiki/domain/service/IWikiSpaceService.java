package io.choerodon.wiki.domain.service;

import io.choerodon.wiki.domain.application.entity.WikiSpaceE;

/**
 * Created by Zenger on 2018/7/3.
 */
public interface IWikiSpaceService {

    void createSpace1(Long id,String param1,String xmlParam);

    void createSpace2(Long id,String param1,String param2,String xmlParam);
}
