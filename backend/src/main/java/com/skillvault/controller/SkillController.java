package com.skillvault.controller;

import com.skillvault.model.Skill;
import com.skillvault.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    // 获取所有技能
    @GetMapping
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    // 添加新技能
    @PostMapping
    public Skill addSkill(@RequestBody Skill skill) {
        return skillRepository.save(skill);
    }

    // 根据 ID 删除技能
    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillRepository.deleteById(id);
    }

    // 修改技能
    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable Long id, @RequestBody Skill updatedSkill) {
        return skillRepository.findById(id).map(skill -> {
            skill.setName(updatedSkill.getName());
            skill.setDescription(updatedSkill.getDescription());
            skill.setProficiency(updatedSkill.getProficiency());
            return skillRepository.save(skill);
        }).orElseGet(() -> {
            // 如果找不到旧数据，就当作新建一个（可选逻辑）
            updatedSkill.setId(id);
            return skillRepository.save(updatedSkill);
        });
    }
}