package com.example.demoquerydsl.testQuery;

import com.example.demoquerydsl.jpa.JPAQueryFactory;
import com.example.demoquerydsl.model.QBlogPost;
import com.example.demoquerydsl.model.QUser;
import com.example.demoquerydsl.model.User;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.jpa.JPAExpressions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

public class TestQuery {

    @PersistenceContext
    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("com.baeldung.querydsl.intro");
    private EntityManagerFactory entityManagerFactory;
    EntityManager em = entityManagerFactory.createEntityManager();
    JPAQueryFactory queryFactory = new JPAQueryFactory(em);


    QUser user = QUser.user;
    QBlogPost blogPost = QBlogPost.blogPost;

    User c = queryFactory.selectFrom(user)
            .where(user.login.eq("David"))
            .fetchOne();

    List b = queryFactory.selectFrom(user)
            .orderBy(user.login.asc())
            .fetch();

    NumberPath count = Expressions.numberPath(Long.class, "c");


    List userTitleCounts = queryFactory.select(
                    blogPost.title, blogPost.id.count().as(count))
            .from(blogPost)
            .groupBy(blogPost.title)
            .orderBy(count.desc())
            .fetch();


    List users = queryFactory.selectFrom(user)
            .where(user.id.in(
                    JPAExpressions.select(blogPost.user.id)
                            .from(blogPost)
                            .where(blogPost.title.eq("Hello World!"))))
            .fetch();


    long d = queryFactory.update(user)
            .where(user.login.eq("Ash"))
            .set(user.login, "Ash2")
            .set(user.disabled, true)
            .execute();

    long a = queryFactory.delete(user)
            .where(user.login.eq("David"))
            .execute();



}
