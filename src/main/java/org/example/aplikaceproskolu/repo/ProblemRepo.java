package org.example.aplikaceproskolu.repo;

import org.example.aplikaceproskolu.objekty.Problem;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;

import java.util.UUID;

public interface ProblemRepo extends JpaAttributeConverter <Problem, UUID> {
}
