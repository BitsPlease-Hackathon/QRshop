package com.bitsplease.qrshop.mapper;

import com.bitsplease.qrshop.domain.entity.BaseEntity;
import com.bitsplease.qrshop.dto.Reference;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Chrisostomos Bakouras
 */
@Component
public class ReferenceMapper {
    @PersistenceContext
    private EntityManager entityManager;

    public <T extends BaseEntity> T resolve(Reference reference, @TargetType Class<T> entityClass) {
        if (Objects.nonNull(reference)) {
            Optional<T> entityOptional = Optional.ofNullable(entityManager.find(entityClass, reference.getId()));

            return entityOptional.orElseThrow(() -> new EntityNotFoundException(entityClass, "id", reference.getId()));
        }

        return null;
    }

    public Reference toReference(BaseEntity entity) {
        if (Objects.nonNull(entity)) {
            Reference reference = new Reference();

            reference.setId(entity.getId());

            return reference;
        }

        return null;
    }
}
