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
@Setter
@Getter
public class PostRequest {

	private Integer id;

    private String text;

    private int upvote;
	
}