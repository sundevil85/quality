/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.kurganmed.quality;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import ru.kurganmed.quality.domain.AnketsResult;
import ru.kurganmed.quality.domain.Answer;
import ru.kurganmed.quality.domain.Quest;
import ru.kurganmed.quality.domain.QuestResult;
import ru.kurganmed.quality.domain.Subq;

/**
 *
 * @author Zhuk
 */
@Named(value = "addAnkets")
@Scope("request")
public class AddAnketsCtrl {

    @Autowired
    private QtyDAO qtyDAO;

    @Inject
    private EventsCtrl evnt; //внедряем текущее событие
    private List<Quest> quests; //список вопросов текущей анкеты
    private int anketId; //ид анкеты, вытаскиваем из текущего события 
    private AnketsResult anketsResult;//полученная анкета

    @PostConstruct
    public void init() {
        anketId = evnt.getCurrentEvent().getAnketId().getId();
        quests = qtyDAO.getQuestByAnketsId(anketId);

        anketsResult = new AnketsResult(evnt.getCurrentEvent()); //создаем заготовку для анкеты     
        anketsResult.setQuestResults(buildQuestResults());//добавляем список ответов по количеству вопросов        
    }

    /*
     метод сохраняет результаты анкетирования
     */
    public void saveAnketsResult() {
        qtyDAO.saveAnketsResult(anketsResult);
    }

    public void clearAndSaveAnketsResult() {
        saveAnketsResult();
        init();
    }

    /*
     возвращает объект результат ответа пользователя из списка вопросов
     для связки с UI компонентами на jsf странице
     */
    public QuestResult getQuestResult(final Quest quest, final Subq subq) {
        for (QuestResult qr : anketsResult.getQuestResults()) {
            if ((qr.getQuest().equals(quest))
                    && (qr.getSubq().equals(subq))) {
                return qr;
            }
        }
        return null;
    }

    public QuestResult getQuestResult(final Quest quest) {
        for (QuestResult qr : anketsResult.getQuestResults()) {
            if (qr.getQuest().equals(quest)) {
                return qr;
            }
        }
        return null;
    }


    /*
     подготавливает список ответов
     разбирает список вопросов включая подвопросы
     */
    private List<QuestResult> buildQuestResults() {
        List<QuestResult> questResults = new ArrayList<>();
        for (Quest q : quests) {
            QuestResult qr;
            if (q.getSubqList().isEmpty()) {
                qr = new QuestResult(anketsResult, q, null);
                questResults.add(qr);
            } else {
                List<Subq> subqList = q.getSubqList();
                for (Subq sq : subqList) {
                    qr = new QuestResult(anketsResult, q, sq);
                    questResults.add(qr);
                }
            }
        }
        return questResults;
    }

    public List<Answer> getAnswerListWithSubQuest(final int questId, final int subqId) {
        return qtyDAO.getAnswerByQuestAndSubQuest(questId, subqId);
    }

    public AnketsResult getAnketsResult() {
        return anketsResult;
    }

    public void setAnketsResult(AnketsResult anketsResult) {
        this.anketsResult = anketsResult;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    public int getAnketId() {
        return anketId;
    }

    public void setAnketId(int anketId) {
        this.anketId = anketId;
    }

}
