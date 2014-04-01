/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kurganmed.quality;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kurganmed.quality.domain.AnketsResult;
import ru.kurganmed.quality.domain.Answer;
import ru.kurganmed.quality.domain.Events;
import ru.kurganmed.quality.domain.Quest;

/**
 *
 * @author Zhuk класс поддержки доступа данных
 */
@Repository("qtyDAO")
@Transactional
public class QtyDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    /*
     возвращает все события
     */
    @Transactional(readOnly = true)
    public List<Events> getEvents() {
        return currentSession().createQuery("from Events as e inner join fetch e.anketId as a order by e.opened desc, e.dateB desc").list();
    }

    /*
     возращает вопросы, зааднной анкеты
     */
    @Transactional(readOnly = true)
    public List<Quest> getQuestByAnketsId(final int anketId) {
        return currentSession().createQuery("select distinct q from Quest as q left join fetch q.answerSet as ans inner join fetch q.anketId "
                + "left join fetch q.subqSet where q.anketId.id=:id and q.questNum in (1) order by q.questNum, ans.answNum").setParameter("id", anketId).list();
    }

    /*
     возвращает варианты ответов по номеру вопроса и номеру подвопроса
     */
    @Transactional(readOnly = true)
    public List<Answer> getAnswerByQuestAndSubQuest(final int questId, final int subqId) {
        return currentSession().createQuery("from Answer a inner join fetch a.questId inner join fetch a.subqId "
                + "where a.questId.id=:qID and a.subqId.id=:suId order by a.answNum").setParameter("qID", questId).
                setParameter("suId", subqId).list();
    }

    /*
     метод возвращает следующуий номер анкеты
     */
    @Transactional(readOnly = true)
    private Integer getNextAnketsReultsNum(final Events event) {
        Integer max = (Integer) currentSession().createQuery("select max(a.anketNum) from AnketsResult a where a.events=:ev").
                setParameter("ev", event).uniqueResult();
        if (max == null) {
            max = 0;
        }
        return max + 1;
    }

    /*
     метод сохраняет результат анкетирования, попутно присваивая порядковый номер
     метод синхронизированный для того чтобы две анкеты не смогли получить один и тот же номер из двух разных потоков
     */
    public synchronized void saveAnketsResult(AnketsResult ar) {
        ar.setAnketNum(getNextAnketsReultsNum(ar.getEvents()));    
        ar.setIpaddr(Util.getIPAddr());
        currentSession().saveOrUpdate(ar);
    }
    
    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public QtyDAO() {
    }
    
}
