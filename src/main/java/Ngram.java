import java.util.*;

public class Ngram {

    public static void main(String[] args) {
        String input = "2,the";

        String text = "Mary had a little lamb its fleece was white as snow;" +
                    "And everywhere that Mary went, the lamb was sure to go. " +
                    "It followed her to school one day, which was against the rule;" +
                    "It made the children laugh and play, to see a lamb at school." +
                    "And so the teacher turned it out, but still it lingered near," +
                    "And waited patiently about till Mary did appear." +
                    "Why does the lamb love Mary so?\" the eager children cry;" +
                    "\"Why, Mary loves the lamb, you know\" the teacher did reply.";

        String[] params = input.split(",");
        String word = params[1];
        int n = Integer.parseInt(params[0]);
        String [] sequences = trimFirstWord(findNgramsOfWord(text, word, n), n);
//        for (String current : sequences) {
//            System.out.println(current);
//        }
        Map<String, Integer> counted = sortByValue(getCountOfWords(sequences));

        Iterator iterator = counted.entrySet().iterator();
        int counter=0;
        while (iterator.hasNext()) {
            if (counter>0) {
                System.out.print(";");
            }
            Map.Entry pair = (Map.Entry)iterator.next();
            System.out.print(pair.getKey() + "," + getProbability((int)pair.getValue(), sequences.length));
            counter++;
        }
    }

    public static String[] findWords(String text) {
        text = text.trim().replaceAll("[^A-Za-z0-9 ]", " ").replaceAll(" +", " ");
        //System.out.println(text);
        return text.split(" ");
    }

    public static String[] findAllNgrams(String text, int n) {
        String[] words = findWords(text);
        String[] result = new String[words.length - n +1];
        for (int i=0; i<result.length; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j=0; j<n; j++) {
                if (j>0) {
                    builder.append(" ");
                }
                builder.append(words[i+j]);
            }
            result[i] = builder.toString();
            //System.out.println(result[i]);
        }
        return result;
    }

    public static String[] findNgramsOfWord(String text, String word, int n) {
        String[] words = findWords(text);
        String[] ngrams = findAllNgrams(text, n-1);
//        for (String current : ngrams) {
//            System.out.println(current);
//        }
        List<String> result = new ArrayList<>();
        for (int i=0; i<ngrams.length-n+1; i++) {
            if (ngrams[i].equals(word)) {
                StringBuilder builder = new StringBuilder();
                for (int j=0; j<n; j++) {
                    if (j>0) {
                        builder.append(" ");
                    }
                    builder.append(words[i+j]);
                }
                result.add(builder.toString());
                //System.out.println(builder);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public static String[] trimFirstWord(String[] ngrams, int n) {
        for (int i=0; i<ngrams.length; i++) {
            for (int j=0; j<n; j++) {
                ngrams[i] = ngrams[i].substring(ngrams[i].indexOf(" ") + 1);
            }
        }
        return ngrams;
    }

    public static Map<String, Integer> getCountOfWords(String[] words) {
        Map<String, Integer> countedWords= new TreeMap<>();
        for (int i=0; i<words.length; i++) {
            if (countedWords.containsKey(words[i])) {
                countedWords.put(words[i], countedWords.get(words[i])+1);
            } else {
                countedWords.put(words[i], 1);
            }
        }
        return countedWords;
    }

    public static String getProbability(int count, int total) {
        Float result = (float)count/total;
        return String.format("%.3f", result);
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

}