package com.challenge.sonusunos.matchmaking;

/**
 * Created by karab on 22/12/14.
 */

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

/*
Problem Name:	MatchMaking
Used In:	SRM 203
Used As:	Division I Level One , Division II Level Two
Categories:	Simulation, Sorting
*/

public class MatchMaking {

    public String makeMatch(String[] namesWoman, String[] answersWomen, String[] namesMan, String[] answersMan, String queryWoman) {

        if (namesWoman.length != namesMan.length || answersMan.length != answersWomen.length)
            return "";

        List<Human> women = new ArrayList<Human>(namesWoman.length);
        List<Human> men = new ArrayList<Human>(namesMan.length);

        for (int i = 0; i < namesWoman.length; i++) {
            women.add(new Human(namesWoman[i], answersWomen[i]));
            men.add(new Human(namesMan[i], answersMan[i]));
        }

        Collections.sort(women);

        for (int j = 0; j < women.size(); j++) {
            Human woman = women.get(j);
            int selectedGuyIndex = 0, selectedGuyMatchRate = 0;
            char[] womanAnswer = woman.getAnswers().toCharArray();

            for (int i = 0; i < men.size(); i++) {
                char[] manAnswer = men.get(i).getAnswers().toCharArray();
                int matchRate = 0;
                for (int i1 = 0; i1 < manAnswer.length; i1++) {
                    if (womanAnswer[i1] == manAnswer[i1])
                        matchRate++;
                }

                if (matchRate > selectedGuyMatchRate) {
                    selectedGuyIndex = i;
                    selectedGuyMatchRate = matchRate;
                    woman.setLuckyGuysName(men.get(i).getName());
                }
            }
        }

        for (Human woman : women) {
            if (woman.getName().contains(queryWoman)) {
                return woman.getLuckyGuysName();
            }
        }

        return "";
    }

    final static class Human implements Comparable {

        private String name;
        private String answers;
        private String luckyGuysName;

        Human(String name, String answers) {
            this.name = name;
            this.answers = answers;
        }

        public int compareTo(Object o) {

            if (!(o instanceof Human)) {
                throw new ClassCastException();
            }

            Human e = (Human) o;

            return name.compareTo(e.name);

        }

        public String getName() {
            return name;
        }

        public String getAnswers() {
            return answers;
        }

        public String getLuckyGuysName() {
            return luckyGuysName;
        }

        public void setLuckyGuysName(String luckyGuysName) {
            this.luckyGuysName = luckyGuysName;
        }
    }
}