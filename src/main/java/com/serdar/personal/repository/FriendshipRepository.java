package com.serdar.personal.repository;

import com.serdar.personal.model.Friendship;
import com.serdar.personal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    List<Friendship> findByUser1OrUser2(User user1, User user2);
    boolean existsByUser1AndUser2(User user1, User user2);
    List<Friendship> findByUser1_IdOrUser2_Id(Long user1Id, Long user2Id);

    @Query("SELECT f FROM Friendship f WHERE " +
            "(f.user1.id = :userId1 AND f.user2.id = :userId2) OR " +
            "(f.user1.id = :userId2 AND f.user2.id = :userId1)")
    Optional<Friendship> findByUsers(@Param("userId1") Long userId1,
                                     @Param("userId2") Long userId2);

}
