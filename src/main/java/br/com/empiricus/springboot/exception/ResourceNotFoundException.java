package br.com.empiricus.springboot.exception;

//BY THIAGOSILVA
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Data
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fielName;
	private Object fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fielName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", resourceName, fielName, fieldValue));
		this.resourceName = resourceName;
		this.fielName = fielName;
		this.fieldValue = fieldValue;
	}
	public ResourceNotFoundException(String string) {

	}

	public String getResourceName() {
		return resourceName;
	}

	public String getFielName() {
		return fielName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	
	
}