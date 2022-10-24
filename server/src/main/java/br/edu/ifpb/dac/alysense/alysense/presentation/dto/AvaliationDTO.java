package br.edu.ifpb.dac.alysense.alysense.presentation.dto;

import java.util.List;
import br.edu.ifpb.dac.alysense.alysense.model.entity.EvalueteItem;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Avaliation.answerAvaliation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AvaliationDTO {
    
    private Long id;

    private answerAvaliation answer;
    private String titleEvent;
    private long evaluator;
    private List<EvalueteItem> evalueteItems;
}
 