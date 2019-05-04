
import java.awt.EventQueue;///////////////FAULTY CARDS: 31
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.List;
import java.awt.Point;
import java.awt.RenderingHints;
import java.applet.Applet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.JScrollBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class WindowBuilder3 extends MouseInputAdapter {

	JFrame frame;
	Random rand = new Random();
	static JTextArea statField;
	static JTextArea PlayerNameTextField;
	static int pMoves;
	JButton drawtCardButton, moveButton, playCardButton, cardButton;

	// ArrayList<String> x = new ArrayList<String>();
	static CardList gameDeck;
	static RoomList rooms = new RoomList();

	static Player currentPlayer;
	static JList<String> roomsList;
	static Room nextRoom;
	static int cardTurn = 0;

	static int randomRoomIndex = 0;
	static int randomCardIndex1 = 0;
	static int randomCardIndex2 = 0;
	ArrayList<Player> pArray;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilder3 window = new WindowBuilder3();
					window.frame.setVisible(true);
				}

				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}// end of MAIN

	// new
	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public WindowBuilder3() throws IOException {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	// Testing - KENNY
	private void initialize() throws IOException {// view
		pMoves = 0;
		gameDeck = new CardList();
		gameDeck.copy();

		// System.out.println(gameDeck.getGameDeck().get(0).getName());

		pArray = new ArrayList<Player>();
		Player p = new Player("Player 1", rooms.getRoomList().get(0), initializePlayerDeck());
		pArray.add(p);
		pArray.add(new Player("Ai 1", rooms.getRoomList().get(0), initializePlayerDeck()));
		pArray.add(new Player("Ai 2", rooms.getRoomList().get(0), initializePlayerDeck()));
		currentPlayer = pArray.get(0); // Ruben

		// print out the map
		BufferedImage img = ImageIO.read(new File("map.png"));

		final ImagePanel imgPane = new ImagePanel(img);
		JScrollPane scrollPane = new JScrollPane(imgPane);
		scrollPane.setBounds(0, 0, 1224, 474);

		frame = new JFrame();
		frame.setTitle("CECS BS Challenge");
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		frame.setSize(1230, 800);
		frame.setResizable(false);

		//// DRAW CARD BUTTOn

		drawtCardButton = new JButton("Draw Card");// add the draw card button
		moveButton = new JButton("Move");// add the move button
		playCardButton = new JButton("Play Card");

		moveButton.setEnabled(false);

		drawtCardButton.addActionListener(new ActionListener() {// listener
			public void actionPerformed(ActionEvent e) {

				drawtCardButton.setEnabled(false);
				moveButton.setEnabled(true);
				playCardButton.setEnabled(true);
				cardButton.setEnabled(true);
				scrollPane.repaint();

			}
		});

		drawtCardButton.setBounds(29, 480, 143, 31);// set bound? what is this?
		frame.getContentPane().add(drawtCardButton);

		moveButton.setBounds(29, 515, 143, 31);
		moveButton.addActionListener(new ActionListener() {// listener
			public void actionPerformed(ActionEvent arg0) {
				int nextRoomIndex = roomsList.getSelectedIndex();
				if (roomsList.getSelectedIndex() == -1) {
					// default title and icon
					JOptionPane.showMessageDialog(frame, "Bruh, choose a room");
				} else {
					currentPlayer = pArray.get(pMoves);

					nextRoom = currentPlayer.getRoom().getNearByRoomArray().get(nextRoomIndex);
					currentPlayer.setRoom(nextRoom);
					setRoomsList();
					// roomsList.setSelectedIndex(0);

					scrollPane.repaint();

					// pMoves++;
					//
					// if (pMoves == 3) {
					// moveButton.setEnabled(false);
					// pMoves=0;
					// }

				}
			}
		});

		frame.getContentPane().add(moveButton);

		playCardButton = new JButton("Play Card");
		playCardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(gameDeck.getGameDeck().size());
				// PlayerNameTextField.setText("Play card " +
				// currentPlayer.getCurrentCard());
				playCardButton.setEnabled(false);
				moveButton.setEnabled(false);
				drawtCardButton.setEnabled(false);
				cardButton.setEnabled(false);

				// DO AI's TURNS via loop
				doAITurn(pArray.get(1));
				doAITurn(pArray.get(2));

				drawtCardButton.setEnabled(true);

				scrollPane.repaint();

				/////////////////////////////////////////////////
				currentPlayer = pArray.get(pMoves);
				currentPlayer.getHand().get(cardTurn).playerHolder = currentPlayer;
				//System.out.println(currentPlayer.getHand().get(cardTurn).getName());
				currentPlayer.getHand().get(cardTurn).playCard();

				printPlayerField();
				printStatField();
				//System.out.println(currentPlayer.getHand().get(cardTurn).getName());

				int cardTurn2 = cardTurn + 1;
				if (cardTurn2 > 4) {
					cardTurn2 = 0;
				}
				cardButton.setIcon(new ImageIcon(currentPlayer.getHand().get(cardTurn2).getImage()));

				if (currentPlayer.getHand().size() != 0) {
					currentPlayer.getHand().remove(cardTurn);
				}

				if (gameDeck.getGameDeck().size() != 0) {
					currentPlayer.getHand().add(gameDeck.getGameDeck().get(0));
					gameDeck.getGameDeck().remove(0);
				}

				//////////////////////////////////////////////////////////
			}
		});

		playCardButton.setEnabled(false);

		playCardButton.setBounds(29, 550, 143, 31);
		frame.getContentPane().add(playCardButton);

		statField = new JTextArea();
		statField.setBounds(490, 490, 711, 171);
		statField.setEditable(false);
		statField.setBackground(Color.WHITE);
		frame.getContentPane().add(statField);
		statField.setColumns(10);
		statField.setFont(new Font("monospaced", Font.PLAIN, 15));
		printStatField();

		PlayerNameTextField = new JTextArea();

		// this.add(textArea); // get rid of this

		PlayerNameTextField.setBounds(490, 674, 694, 65);
		PlayerNameTextField.setEditable(false);
		PlayerNameTextField.setBackground(Color.WHITE);

		PlayerNameTextField.setColumns(10);
		PlayerNameTextField.setFont(new Font("monospaced", Font.PLAIN, 15));

		JScrollPane PlayerNameTextFieldScroll = new JScrollPane(PlayerNameTextField);
		PlayerNameTextFieldScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		PlayerNameTextFieldScroll.setBounds(490, 674, 711, 65);
		// frame.getContentPane().add(PlayerNameTextField);
		frame.getContentPane().add(PlayerNameTextFieldScroll);

		// create fly image
		ImageIcon flyIcon = new ImageIcon(
				new ImageIcon("fly.png").getImage().getScaledInstance(230, 328, Image.SCALE_DEFAULT));
		JLabel FlyLabel = new JLabel();
		FlyLabel.setIcon(flyIcon);
		FlyLabel.setBounds(0, 0, 100, 25);
		frame.getContentPane().add(FlyLabel);

		//// new

		imgPane.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {

				int x = me.getX();
				int y = me.getY();

				FlyLabel.setLocation(x, y);
				imgPane.add(FlyLabel);

				//System.out.println("You clicked at (" + x + "," + y + ")");

			}
		});

		// new
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		frame.getContentPane().add(scrollPane);// add schrol panel

		cardButton = new JButton("Current Card");
		cardButton.setBounds(247, 490, 190, 270);

		frame.getContentPane().add(cardButton);
		cardButton.setIcon(new ImageIcon(currentPlayer.getHand().get(0).getImage()));
		cardButton.setEnabled(false);

		cardButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardTurn++;
				if (cardTurn > 4) {
					cardTurn = 0;
				}
				cardButton.setIcon(new ImageIcon(currentPlayer.getHand().get(cardTurn).getImage()));

				// System.out.println(gameDeck.getGameDeck().get(0).cardName);

			}
		});

		// initialize the JList with the the human player's current room
		int numRooms = currentPlayer.getRoom().getNearByRoomArray().size();
		String roomNames[] = new String[numRooms];

		// the constructor takes an array, so populate the array from the
		// arrayList
		for (int i = 0; i < numRooms; i++) {
			roomNames[i] = currentPlayer.getRoom().getNearByRoomArray().get(i).getRoomName();
		}

		roomsList = new JList<String>(roomNames);

		setRoomsList();
		// roomsList.setSelectedIndex(0);
		roomsList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		roomsList.setLayoutOrientation(JList.VERTICAL);
		roomsList.setVisibleRowCount(1);
		roomsList.setBounds(29, 592, 143, 155);
		roomsList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				int nextRoomIndex = roomsList.getSelectedIndex();

				// after moving, it resets to -1
				if (nextRoomIndex == -1)
					nextRoomIndex = 0;

				nextRoom = currentPlayer.getRoom().getNearByRoomArray().get(nextRoomIndex);
			}
		});
		frame.getContentPane().add(roomsList);

	}// initialize

	public static void setRoomsList() {

		int numRooms = currentPlayer.getRoom().getNearByRoomArray().size();
		String roomNames[] = new String[numRooms];

		// the constructor takes an array, so populate the array from the
		// arrayList
		for (int i = 0; i < numRooms; i++) {
			roomNames[i] = currentPlayer.getRoom().getNearByRoomArray().get(i).getRoomName();
		}

		roomsList.setListData(roomNames);
		// roomsList.setSelectedIndex(0);
	}

	public ArrayList<Card> initializePlayerDeck() {
		ArrayList<Card> playerDeck = new ArrayList<Card>();

		if (gameDeck.getGameDeck().size() >= 5) {
			for (int i = 0; i < 5; i++) {
				playerDeck.add(gameDeck.getGameDeck().get(0));
				// System.out.println(gameDeck.getGameDeck().get(0).getName());
				gameDeck.getGameDeck().remove(0);
			}
		}

		return playerDeck;
	}

	public void doAITurn(Player p) {

		for (int i = 0; i < 3; i++) {
			int size = p.getRoom().getNearByRoomArray().size();

			randomRoomIndex = rand.nextInt(size);
			p.setRoom(p.getRoom().getNearByRoomArray().get(randomRoomIndex));

		}
		
		if (gameDeck.getGameDeck().size() == 0) {
			gameDeck.repopulate();
		}
		
			
		
		System.out.println("           GAME DECK SIZE: "+gameDeck.getGameDeck().size());
		if (p.getHand().size() > 0) {
		int randomCardIndex = 0;
		if (p.equals(pArray.get(1))) {
			randomCardIndex1 = rand.nextInt(p.getHand().size() -1);
			randomCardIndex = randomCardIndex1;
		}
		if (p.equals(pArray.get(2))) {
			randomCardIndex2 = rand.nextInt(p.getHand().size() -1);
			randomCardIndex = randomCardIndex2;
		}
		
		p.getHand().get(randomCardIndex).playerHolder = p;
		//System.out.println("random card index:" + randomCardIndex);
		p.getHand().get(randomCardIndex).playCard();
		printPlayerField();
		
		if (p.getHand().size() != 0) {
			p.getHand().remove(randomCardIndex);
		}
		int cardTurn3 = randomCardIndex++;
		if (cardTurn3 > 4) {
			cardTurn3 = 0;
		}
		if (gameDeck.getGameDeck().size() != 0) {

			p.getHand().add(gameDeck.getGameDeck().get(0));
			gameDeck.getGameDeck().remove(0);
		}
		}
	}

	public void printStatField() {
		statField.setText("");
		statField.append(
				String.format("%-15s%-15s%-15s%-15s%-15s%n", " ", "Learning", "Craft", "Integrity", "Quality Point"));
		statField.append(String.format("%-15s%-15s%-15s%-15s%-15s%n", pArray.get(0).getName(), pArray.get(0).getLearn(),
				pArray.get(0).getCraft(), pArray.get(0).getIntegrity(), pArray.get(0).getQuality()));
		statField.append(String.format("%-15s%-15s%-15s%-15s%-15s%n", pArray.get(1).getName(), pArray.get(1).getLearn(),
				pArray.get(1).getCraft(), pArray.get(1).getIntegrity(), pArray.get(1).getQuality()));
		statField.append(String.format("%-15s%-15s%-15s%-15s%-15s%n", pArray.get(2).getName(), pArray.get(2).getLearn(),
				pArray.get(2).getCraft(), pArray.get(2).getIntegrity(), pArray.get(2).getQuality()));
		statField.append("Cards in deck: 	\n");
		statField.append("Discards out of play: \n");
		statField.append("You are " + currentPlayer.getName() + " and you are in " + currentPlayer.getRoom().roomName);
	}

	public void printPlayerField() {
		System.out.println("randomCardIndex1:"+randomCardIndex1);
		System.out.println("randomCardIndex2:"+randomCardIndex2);
		System.out.println("PLAYER 1:"+pArray.get(0).getHand().size());
		System.out.println("AI 1:"+pArray.get(1).getHand().size());
		System.out.println("AI 2:"+pArray.get(2).getHand().size());
		PlayerNameTextField.setText(pArray.get(0).getName() + " played "
				+ pArray.get(0).getHand().get(cardTurn).getName() + "\n" + pArray.get(1).getName() + " played "
				+ pArray.get(1).getHand().get(randomCardIndex1).getName() + "\n" + pArray.get(2).getName() + " played "
				+ pArray.get(2).getHand().get(randomCardIndex2).getName());
	}

	public class ImagePanel extends JPanel {// COPIED CODE. NEED REVISED

		private BufferedImage image;

		public ImagePanel(BufferedImage img) {
			image = img;
		}

		protected Point getImageLocation() {

			Point p = null;
			if (image != null) {
				int x = (getWidth() - image.getWidth()) / 2;
				int y = (getHeight() - image.getHeight()) / 2;
				p = new Point(x, y);
			}
			return p;

		}

		public Dimension getPreferredSize() {
			return image == null ? super.getPreferredSize() : new Dimension(image.getWidth(), image.getHeight());
		}

		public Point toImageContext(Point p) {
			Point imgLocation = getImageLocation();
			Point relative = new Point(p);
			relative.x -= imgLocation.x;
			relative.y -= imgLocation.y;
			return relative;
		}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			Point p = getImageLocation();
			int x = p.x;
			int y = p.y;

			g.drawImage(image, x, y, this);
			g.setColor(Color.RED);
			g.setFont(new Font("Monospaced", Font.BOLD, 24));
			g.drawString(pArray.get(0).getName(), pArray.get(0).getRoom().xCoord, pArray.get(0).getRoom().yCoord);
			g.drawString(pArray.get(1).getName(), pArray.get(1).getRoom().xCoord, pArray.get(1).getRoom().yCoord + 20);
			g.drawString(pArray.get(2).getName(), pArray.get(2).getRoom().xCoord, pArray.get(2).getRoom().yCoord - 20);
		}

	}
}
