package org.sopt.korailtalk.train.repository;

import org.sopt.korailtalk.train.domain.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {

}
