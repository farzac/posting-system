/**
 * @author fabioz
 *
 */
package com.fabioz.api.payload.response;

import lombok.Getter;
import lombok.Setter;


/**
 * @author fabioz
 *
 */
@Getter
@Setter
public class PostResponse {

	private Integer id;

    private String text;

    private int upvote;
	
}