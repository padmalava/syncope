/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.syncope.core.rest.cxf.service;

import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import org.apache.syncope.common.lib.to.AttrRepoTO;
import org.apache.syncope.common.rest.api.RESTHeaders;
import org.apache.syncope.common.rest.api.service.AttrRepoService;
import org.apache.syncope.core.logic.AttrRepoLogic;

public class AttrRepoServiceImpl extends AbstractService implements AttrRepoService {

    protected final AttrRepoLogic logic;

    public AttrRepoServiceImpl(final AttrRepoLogic logic) {
        this.logic = logic;
    }

    @Override
    public Response create(final AttrRepoTO attrRepoTO) {
        AttrRepoTO attrRepo = logic.create(attrRepoTO);
        URI location = uriInfo.getAbsolutePathBuilder().path(attrRepo.getKey()).build();
        return Response.created(location).
                header(RESTHeaders.RESOURCE_KEY, attrRepo.getKey()).
                build();
    }

    @Override
    public void delete(final String key) {
        logic.delete(key);
    }

    @Override
    public List<AttrRepoTO> list() {
        return logic.list();
    }

    @Override
    public AttrRepoTO read(final String key) {
        return logic.read(key);
    }

    @Override
    public void update(final AttrRepoTO attrRepoTO) {
        logic.update(attrRepoTO);
    }
}
