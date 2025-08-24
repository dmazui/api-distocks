package com.dimaz.api_distocks.Repository;

import com.dimaz.api_distocks.domain.Acao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcaoRepository extends JpaRepository <Acao, Long> {

}
