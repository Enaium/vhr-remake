/*
 * Copyright 2023 Enaium
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.enaium.vhr.controller.config

import cn.dev33.satoken.stp.StpUtil
import cn.enaium.vhr.model.entity.Menu
import cn.enaium.vhr.model.result.Result
import cn.enaium.vhr.repository.MenuRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Enaium
 */
@RestController
@RequestMapping("/system")
class SystemController(val menuRepository: MenuRepository) {
    @GetMapping("/menu")
    fun get(): Result<List<Menu>?> {
        return Result.Builder.success(metadata = menuRepository.findAllByHrId(StpUtil.getLoginIdAsInt()))
    }
}