package com.beta.ms.auth.service;

import com.beta.ms.auth.dao.RoleEntityDao;
import com.beta.ms.auth.entity.RoleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class RoleService {
    @Autowired
    RoleEntityDao roleEntityDao;

    public RoleEntity createRoleEntity(RoleEntity inputEntity) {
        try {
            return roleEntityDao.save(inputEntity);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    public RoleEntity updateRoleEntity(RoleEntity inputEntity) throws Exception {
        try {
            if (inputEntity.getId() == null || inputEntity.getId() <= 0) {
                throw new Exception("Invalid entity ID to update");
            }
            Optional<RoleEntity> optionalRoleEntity = roleEntityDao.findById(inputEntity.getId());

            if (!optionalRoleEntity.isPresent()) {
                throw new Exception("Object not found");
            } else {
                RoleEntity roleEntity = mergeRoleEntity(optionalRoleEntity.get(), inputEntity);
                return roleEntityDao.save(roleEntity);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }

    private RoleEntity mergeRoleEntity(RoleEntity existingEntity, RoleEntity inputEntity) {
        existingEntity.setName(inputEntity.getName());
        existingEntity.setDescription(inputEntity.getDescription());
        return existingEntity;
    }
}
