package io.choerodon.wiki.api.controller.v1;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.choerodon.core.iam.InitRoleCode;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.swagger.annotation.Permission;
import io.choerodon.wiki.app.service.WikiScanningService;
import io.choerodon.wiki.infra.common.Stage;

/**
 * Created by Zenger on 2018/7/18.
 */
@RestController
@RequestMapping(value = "/v1/organizations/{organization_id}/space")
public class WikiScanningController {

    private WikiScanningService wikiScanningService;

    public WikiScanningController(WikiScanningService wikiScanningService) {
        this.wikiScanningService = wikiScanningService;
    }

    /**
     * 扫描组织和项目
     *
     * @param organizationId 组织id
     * @return DevopsServiceDTO
     */
    @Permission(level = ResourceLevel.ORGANIZATION,
            roles = {InitRoleCode.ORGANIZATION_ADMINISTRATOR,
                    Stage.ORGANIZATION_MEMBER})
    @ApiOperation(value = "扫描组织和项目")
    @GetMapping(value = "/scan")
    public ResponseEntity query(
            @ApiParam(value = "组织ID", required = true)
            @PathVariable(value = "organization_id") Long organizationId) {
        wikiScanningService.scanning();
        return new ResponseEntity(HttpStatus.OK);
    }

    @Permission(level = ResourceLevel.ORGANIZATION,
            roles = {InitRoleCode.ORGANIZATION_ADMINISTRATOR,
                    Stage.ORGANIZATION_MEMBER})
    @ApiOperation(value = "同步指定组织和项目组织和项目")
    @GetMapping("/sync_org")
    public ResponseEntity syncOrg(@ApiParam(value = "组织ID", required = true)
                         @PathVariable(value = "organization_id") Long organizationId){
        wikiScanningService.syncOrg(organizationId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Permission(level = ResourceLevel.ORGANIZATION,
            roles = {InitRoleCode.ORGANIZATION_ADMINISTRATOR,
                    Stage.ORGANIZATION_MEMBER})
    @ApiOperation(value = "删除指定的空间")
    @GetMapping("/delete_space")
    public ResponseEntity<Boolean> deleteSpace(@RequestParam("id") Long id) {
        return new ResponseEntity<Boolean>(wikiScanningService.deleteSpaceById(id), HttpStatus.OK);
    }
}
