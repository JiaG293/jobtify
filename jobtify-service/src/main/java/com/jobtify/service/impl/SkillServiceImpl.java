package com.jobtify.service.impl;

import com.jobtify.dto.request.SkillCreateRequest;
import com.jobtify.dto.request.SkillUpdateRequest;
import com.jobtify.dto.response.SkillResponse;
import com.jobtify.exception.AppException;
import com.jobtify.exception.ErrorCode;
import com.jobtify.model.mapper.SkillMapper;
import com.jobtify.repository.SkillRepository;
import com.jobtify.service.SkillService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class SkillServiceImpl implements SkillService {
    SkillRepository skillRepository;
    SkillMapper skillMapper;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public SkillResponse createSkillBase(SkillCreateRequest request) {
        var skill = skillRepository.findAllBySkillName(request.getSkillName());
        if (skill.isPresent()) {
            throw new AppException(ErrorCode.SKILL_NAME_EXISTED);
        }

        var skillSave = skillRepository.save(skillMapper.toSkill(request));
        log.info("skill save {}", skillSave);
        return skillMapper.toSkillResponse(skillSave);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public SkillResponse updateSkill(String skillId, SkillUpdateRequest request) {
        var skill = skillRepository.findById(skillId)
                .orElseThrow(() -> new AppException(ErrorCode.SKILL_NOT_EXISTED));

        skillMapper.updateRequestToSkill(request, skill);


        skillRepository.save(skill);

        return skillMapper.toSkillResponse(skillRepository.save(skill));
    }

    @Override
    public void deleteSkill(String skillId) {
        try {
            var skill = skillRepository.findById(skillId)
                    .orElseThrow(() -> new AppException(ErrorCode.SKILL_NOT_EXISTED));
            skillRepository.delete(skill);
        } catch (AppException e) {
            throw new AppException(ErrorCode.CONFLICT_DELETE);
        }
    }

    @Override
    public Page<SkillResponse> findAll(int page, int size, String sortBy, String sortDirection) {
        String defaultSortDirection = sortDirection.equalsIgnoreCase("asc") ? sortDirection : "desc";

        Sort sort = Sort.by(Sort.Direction.fromString(defaultSortDirection), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        return skillRepository.findAll(pageable).map(skill -> skillMapper.toSkillResponse(skill));
    }

    @Override
    public Page<SkillResponse> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<SkillResponse> list;
        List<SkillResponse> listSkill = skillRepository.findAll()
                .stream()
                .map(skill -> skillMapper.toSkillResponse(skill))
                .collect(Collectors.toList());

        if (listSkill.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, listSkill.size());
            list = listSkill.subList(startItem, toIndex);
        }

        Page<SkillResponse> skillResponsePage
                = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), listSkill.size());

        return skillResponsePage;
    }


}
