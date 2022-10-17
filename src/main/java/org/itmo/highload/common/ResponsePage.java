package org.itmo.highload.common;

import lombok.*;

import java.util.Collection;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePage {
    private Collection<?> collection;
    private boolean hasMore;

}
