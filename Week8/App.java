import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import java.awt.*;

import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.TreeMap;
class MyFrame extends JFrame implements ListSelectionListener{
    JPanel panel,containPanel;
    JLabel label;
    JTextArea textArea;
    JList<String> list;
    JScrollPane scrollPaneList,scrollPaneTextArea;
    String[] citys = {"台北","新北","基隆","桃園","台中","彰化","高雄"};
    TreeMap<String,ArrayList<String>> cityMountain = new TreeMap<>();
    MyFrame(){
        /* 數值建立 */
        ArrayList<String> taipai = new ArrayList<>();
        taipai.add("陽明山");
        cityMountain.put("台北",taipai);

        ArrayList<String> newTaipai = new ArrayList<>();
        newTaipai.add("觀音山");
        cityMountain.put("新北",newTaipai);

        ArrayList<String> keelung = new ArrayList<>();
        keelung.add("紅蛋山");
        keelung.add("益壽山");
        cityMountain.put("基隆",keelung);

        ArrayList<String> taoyuan = new ArrayList<>();
        taoyuan.add("三分山");
        cityMountain.put("桃園",taoyuan);

        ArrayList<String> taichung = new ArrayList<>();
        taichung.add("三汀山");
        cityMountain.put("台中",taichung);

        ArrayList<String> Changhua = new ArrayList<>();
        Changhua.add("八卦山");
        Changhua.add("百果山");
        cityMountain.put("彰化",Changhua);

        ArrayList<String> kaohsiung  = new ArrayList<>();
        kaohsiung.add("壽山");
        cityMountain.put("高雄",kaohsiung);

        /* 初始化一部分UI物件 */
        containPanel = new JPanel();
        containPanel.setLayout(new GridBagLayout());
        containPanel.setBorder(BorderFactory.createEtchedBorder());  
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(1,1));
        label = new JLabel();
        label.setPreferredSize(new Dimension(200, 100));
        textArea = new JTextArea("可選取地名...",5,25);
        list = new JList<String>();
        setTitle("找各地名山");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 400, 400);

        /* lable設定 */
        label.setText("各地名山");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        /* textarea設定 */
        textArea.setLineWrap(true);

        /* List設定 */
        list.setVisibleRowCount(4);
        list.setListData(citys);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setVerifyInputWhenFocusTarget(false);
        list.addListSelectionListener(this);   


        /* 加上Scrollbar */
        scrollPaneList = new JScrollPane(list,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneTextArea = new JScrollPane(textArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        /* 排版 */
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0;
        // 設定lable
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.fill = GridBagConstraints.HORIZONTAL;
        containPanel.add(label, gbc);
        
        //設定List
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        containPanel.add(scrollPaneList, gbc);
        //設定area
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        containPanel.add(scrollPaneTextArea, gbc);

        //加入Frame
        panel.add(containPanel);
        add(panel);
        setVisible(true);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        //isSelectionEmpty()
        //由於當我按下放開時會觸發兩次event透過getValueIsAdjusting()排除mouse up
        if(list.getValueIsAdjusting()){
            StringBuilder output = new StringBuilder();
            for(String city:list.getSelectedValuesList()){
                output.append(city+" 名山：");
                for(String mountain:cityMountain.get(city)){
                    output.append(mountain+" ");
                }
                output.append("\n");
            }
            textArea.setText(output.toString());
        }

    }
}

public class App {
    public static void main(String[] args){
        new MyFrame();
    }
}