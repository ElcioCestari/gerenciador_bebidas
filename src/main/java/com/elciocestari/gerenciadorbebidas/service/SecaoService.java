package com.elciocestari.gerenciadorbebidas.service;

import com.elciocestari.gerenciadorbebidas.dto.MessageResponseDTO;
import com.elciocestari.gerenciadorbebidas.dto.SecaoDTO;
import com.elciocestari.gerenciadorbebidas.entity.Secao;
import com.elciocestari.gerenciadorbebidas.exception.NumeroMaximoDeSecaoException;
import com.elciocestari.gerenciadorbebidas.mapper.SecaoMapper;
import com.elciocestari.gerenciadorbebidas.repository.SecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecaoService {

    private SecaoRepository secaoRepository;
    private SecaoMapper secaoMapper = SecaoMapper.INSTANCE;

    private static final int  NUMERO_MAXIMO_SECAO = 5;

    @Autowired
    public SecaoService(SecaoRepository secaoRepository) {
        this.secaoRepository = secaoRepository;
    }

    public Secao create(SecaoDTO secaoDTO) throws NumeroMaximoDeSecaoException {

        if (this.getAll().size() >= NUMERO_MAXIMO_SECAO) {
            throw new NumeroMaximoDeSecaoException();
        }

        Secao secaoToSave = secaoMapper.toModel(secaoDTO);
        return secaoRepository.save(secaoToSave);
    }

    public List<Secao> getAll() {
        return secaoRepository.findAll();
    }

    public Secao update(SecaoDTO secaoDTO, long id) {
        return secaoRepository.findById(id)
                        .map(secao -> {
                            secao = secaoMapper.toModel(secaoDTO);
                            secao.setId(id);
                            return secaoRepository.save(secao);
                        }).orElse(null);

    }

    public Boolean delete(long id) {
        return secaoRepository.findById(id)
                .map(secao -> {
                    secaoRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
