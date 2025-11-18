package com.huangming.wecook.repo;

import com.huangming.wecook.dataclass.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepo extends JpaRepository<Message, Integer> {
}
