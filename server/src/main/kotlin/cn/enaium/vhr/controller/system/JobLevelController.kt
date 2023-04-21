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

package cn.enaium.vhr.controller.system

import cn.enaium.vhr.model.entity.JobLevel
import cn.enaium.vhr.model.entity.input.JobLevelInput
import cn.enaium.vhr.model.result.ResponseResult
import cn.enaium.vhr.repository.JobLevelRepository
import org.springframework.web.bind.annotation.*

/**
 * @author Enaium
 */
@RestController
@RequestMapping("/system/jobLevel")
class JobLevelController(
    val jobLevelRepository: JobLevelRepository
) {
    @GetMapping
    fun get(): ResponseResult<List<JobLevel>?> {
        return ResponseResult.Builder.success(metadata = jobLevelRepository.findAll())
    }

    @PutMapping
    fun save(@RequestBody jobLevelInput: JobLevelInput): ResponseResult<Nothing?> {
        jobLevelRepository.save(jobLevelInput)
        return ResponseResult.Builder.success()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ResponseResult<Nothing?> {
        jobLevelRepository.deleteById(id)
        return ResponseResult.Builder.success()
    }
}