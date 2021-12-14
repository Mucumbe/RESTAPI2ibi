package co.mz.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Blandino Junior Sibone Mucumbe
 *
 */
@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SubRegiao {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
}
