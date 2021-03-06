package io.choerodon.wiki.domain.service.impl;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import io.choerodon.core.exception.CommonException;
import io.choerodon.wiki.domain.service.IWikiSpaceWebHomeService;
import io.choerodon.wiki.infra.common.BaseStage;
import io.choerodon.wiki.infra.feign.WikiClient;

/**
 * Created by Zenger on 2018/7/3.
 */
@Service
public class IWikiSpaceWebHomeServiceImpl implements IWikiSpaceWebHomeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(IWikiSpaceWebHomeServiceImpl.class);

    @Value("${wiki.client}")
    private String client;

    private WikiClient wikiClient;

    public IWikiSpaceWebHomeServiceImpl(WikiClient wikiClient) {
        this.wikiClient = wikiClient;
    }

    @Override
    public int createSpace1WebHome(String param1, String xmlParam, String username) {
        LOGGER.info("create webhome,path: {}", param1);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("create webhome request xml: {}", xmlParam);
        }
        Response<ResponseBody> response;
        try {
            RequestBody requestBody = RequestBody.create(MediaType.parse(BaseStage.APPXML), xmlParam);
            response = wikiClient.createSpace1WebHome(username,
                    client, param1, requestBody).execute();
            LOGGER.info("create webhome code:{} ", response.code());
        } catch (IOException e) {
            throw new CommonException("error.webhome.create", e);
        }

        return response.code();
    }

    @Override
    public int createSpace2WebHome(String param1, String param2, String xmlParam, String username) {
        LOGGER.info("create webhome,path: {}/{}", param1, param2);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("create webhome request xml: {}", xmlParam);
        }
        Response<ResponseBody> response;
        try {
            RequestBody requestBody = RequestBody.create(MediaType.parse(BaseStage.APPXML), xmlParam);
            response = wikiClient.createSpace2WebHome(username,
                    client, param1, param2, requestBody).execute();
            LOGGER.info("create webhome code:{} ", response.code());
        } catch (IOException e) {
            throw new CommonException("error.webhome.create", e);
        }

        return response.code();
    }

    @Override
    public int createSpace3WebHome(String param1, String param2, String param3, String xmlParam, String username) {
        LOGGER.info("create webhome,path: {}/{}/{}", param1, param2, param3);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("create webhome request xml: {}", xmlParam);
        }
        Response<ResponseBody> response;
        try {
            RequestBody requestBody = RequestBody.create(MediaType.parse(BaseStage.APPXML), xmlParam);
            response = wikiClient.createSpace3WebHome(username,
                    client, param1, param2, param3, requestBody).execute();
            LOGGER.info("create webhome code:{} ", response.code());
        } catch (IOException e) {
            throw new CommonException("error.webhome.create", e);
        }

        return response.code();
    }

    @Override
    public int deletePage(String param1, String page, String username) {
        LOGGER.info("delete page,path: {} and page: {}", param1, page);
        Response<ResponseBody> response;
        try {
            response = wikiClient.deletePage(username,
                    client, param1, page).execute();
            LOGGER.info("delete page code:{} ", response.code());
        } catch (IOException e) {
            throw new CommonException("error.webhome.delete", e);
        }

        return response.code();
    }

    @Override
    public int deletePage1(String param1, String param2, String page, String username) {
        LOGGER.info("delete page,path: {}/{} and page: {}", param1, param2, page);
        Response<ResponseBody> response;
        try {
            response = wikiClient.deletePage1(username,
                    client, param1, param2, page).execute();
            LOGGER.info("delete page code:{} ", response.code());
        } catch (IOException e) {
            throw new CommonException("error.webhome.delete", e);
        }

        return response.code();
    }

    @Override
    public int deletePage2(String param1, String param2, String param3, String page, String username) {
        LOGGER.info("delete page,path: {}/{}/{} and page: {}", param1, param2, param3, page);
        Response<ResponseBody> response;
        try {
            response = wikiClient.deletePage2(username,
                    client, param1, param2, param3, page).execute();
            LOGGER.info("delete page code:{} ", response.code());
        } catch (IOException e) {
            throw new CommonException("error.webhome.delete", e);
        }

        return response.code();
    }
}
