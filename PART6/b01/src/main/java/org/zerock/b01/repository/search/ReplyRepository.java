package org.zerock.b01.repository.search;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b01.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
