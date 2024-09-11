package veritas.script;

import org.json.JSONArray;
import org.json.JSONObject;

import common.RestUtil;
import common.SSLUtilities;
import veritas.script.otherstream.RetriggerDeliverToCCE;

public class CorrectSoldToRetrigger {
	
//	https://veritasmongoservicessit.ausvdc02.pcf.dell.com/api/service/getPOARDataE?PONumber=CP397386&INV_Number=TICP397386";
	
//	private static String getInvoiceDataURL_sit = "https://veritasmongoservicessit.ausvdc02.pcf.dell.com/api/service/getPOARDataE?PONumber=CP397386&INV_Number=TICP397386";
	private static String MongoService_prod = "https://veritasmongoservices.veritas.pcf.dell.com/api/service/";

	
//	private static String deliverToCCETriggerEvent_sit = "https://veritasbacksit.ausvdc02.pcf.dell.com/DeliverToCCETriggerEvent";
	private static String deliverToCCETriggerEvent_prod = "https://veritasback.veritas.pcf.dell.com/DeliverToCCETriggerEvent";

	
	
		
		
	private static RestUtil restutil = new RestUtil();
	public static void main(String[] args) {
		SSLUtilities.trustAllHostnames();
		SSLUtilities.trustAllHttpsCertificates();
		String dataPOnumberInvoicenum = "[[\"UTTYL.0000038458\",\"10686326214\"], [\"V000161003\",\"10676350703\"], [\"UTH174853\",\"10684811323\"], [\"UTH173943\",\"10684731563\"], [\"UTH173712\",\"10684731547\"], [\"UTP174078\",\"10684619512\"], [\"S378586\",\"10684674508\"], [\"UTP174079\",\"10684619504\"], [\"UTH174274\",\"10684731580\"], [\"UTH176030\",\"10684988245\"], [\"UTH174397\",\"10684955331\"], [\"UTP175745\",\"10684834592\"], [\"UTH175207\",\"10684887207\"], [\"UTH175083\",\"10684955489\"], [\"UTH175030\",\"10684887178\"], [\"UTH173227\",\"10684732373\"], [\"UTH174059\",\"10684886907\"], [\"UTH173279\",\"10684988018\"], [\"UTP175454\",\"10685270036\"], [\"UTH175217\",\"10685218909\"], [\"UTH175452\",\"10685245428\"], [\"UTH175255\",\"10685200133\"], [\"UTH174882\",\"10685127500\"], [\"UTH174931\",\"10685357009\"], [\"UTH173541\",\"10685356952\"], [\"UTH176388\",\"10685417332\"], [\"UTP175598\",\"10685597394\"], [\"UTP175743\",\"10685539557\"], [\"UTH172757\",\"10685693370\"], [\"UTH176285\",\"10685566543\"], [\"UTP176057\",\"10685686494\"], [\"UTP175830\",\"10685686443\"], [\"UTP176049\",\"10685686486\"], [\"UTP176223\",\"10685686507\"], [\"UTH174684\",\"10685640883\"], [\"UTH176817\",\"10685888858\"], [\"UTH175930\",\"10685869232\"], [\"UTH175971\",\"10685900447\"], [\"UTH174407\",\"10685900228\"], [\"UTH174935\",\"10686189669\"], [\"UTH176195\",\"10686206349\"], [\"UTH175226\",\"10686206074\"], [\"UTH175684\",\"10686206200\"], [\"UTH175578\",\"10686189781\"], [\"UTH175769\",\"10686189896\"], [\"UTP174597\",\"10686205993\"], [\"UTH173928\",\"10686189520\"], [\"P1052883\",\"10684734410\"], [\"V000163211\",\"10684619133\"], [\"P500024874\",\"10684569590\"], [\"UTH122877\",\"10685558099\"]]";
		dataPOnumberInvoicenum = "[[\"5000057398\",\"10680913316\"], [\"5000059481\",\"10689699190\"], [\"5000059210\",\"10689828519\"], [\"5000059701\",\"10690411385\"], [\"5000059644\",\"10690643181\"], [\"5000059917\",\"10691945586\"], [\"5000059763\",\"10692383504\"], [\"5000059766\",\"10692383512\"], [\"5000059754\",\"10692360759\"], [\"5000059751\",\"10692719696\"], [\"5000059890\",\"10692719717\"], [\"5000059747\",\"10692701179\"], [\"5000059891\",\"10692701216\"], [\"5000059857\",\"10692886289\"], [\"5000060289\",\"10693657547\"], [\"5000060150\",\"10693818622\"], [\"5000060587\",\"10693914633\"], [\"5000060403\",\"10694105723\"], [\"5000060397\",\"10694068036\"], [\"5000060171\",\"10694105467\"], [\"5000060506\",\"10694068204\"], [\"5000060535\",\"10694195947\"], [\"5000060390\",\"10694877285\"], [\"5000060673\",\"10694720211\"], [\"5000060533\",\"10694877365\"], [\"PO105027294\",\"10680809731\"], [\"PO105032097\",\"10680998011\"], [\"PO105029077\",\"10680892945\"], [\"PO105029422\",\"10680892953\"], [\"PO105029610\",\"10680997965\"], [\"PO105029958\",\"10680840803\"], [\"PO105032359\",\"10680998062\"], [\"PO105029562\",\"10680892988\"], [\"PO105027679\",\"10680935177\"], [\"PO105027277\",\"10680892857\"], [\"PO105033684\",\"10680935505\"], [\"PO105028098\",\"10680809766\"], [\"PO105030001\",\"10680809918\"], [\"PO105032220\",\"10680893069\"], [\"PO105034310\",\"10680998126\"], [\"PO105041634\",\"10682931923\"], [\"PO105108979\",\"10689753353\"], [\"PO105111221\",\"10689753388\"], [\"PO105111927\",\"10689704012\"], [\"PO105114780\",\"10689753572\"], [\"PO105116663\",\"10689753601\"], [\"PO105111502\",\"10689792691\"], [\"PO105114149\",\"10689732708\"], [\"PO105115873\",\"10689753548\"], [\"PO105096357\",\"10689732484\"], [\"PO105108657\",\"10689792640\"], [\"PO105111471\",\"10689835120\"], [\"PO105111650\",\"10689792720\"], [\"PO105114641\",\"10689704127\"], [\"PO105115818\",\"10689753530\"], [\"PO105116416\",\"10689850270\"], [\"PO105118138\",\"10689704338\"], [\"PO105117062\",\"10689753580\"], [\"PO105111659\",\"10689703990\"], [\"PO105114221\",\"10689850123\"], [\"PO105105821\",\"10689703798\"], [\"PO105113950\",\"10689753492\"], [\"PO105113959\",\"10689753505\"], [\"PO105117138\",\"10690076006\"], [\"PO105114640\",\"10690041152\"], [\"PO105116777\",\"10689961789\"], [\"PO105120410\",\"10690115524\"], [\"PO105114187\",\"10690008487\"], [\"PO105115821\",\"10690075933\"], [\"PO105116896\",\"10689961797\"], [\"PO105117998\",\"10689961877\"], [\"PO105116565\",\"10690041267\"], [\"PO105116988\",\"10689961834\"], [\"PO105114236\",\"10690075917\"], [\"PO105115828\",\"10690008583\"], [\"PO105116977\",\"10689961818\"], [\"PO105117491\",\"10689961850\"], [\"PO105121385\",\"10690053470\"], [\"PO105125307\",\"10690202887\"], [\"PO105116575\",\"10690197330\"], [\"PO105117412\",\"10690197349\"], [\"PO105112636\",\"10690187813\"], [\"PO105123210\",\"10690223713\"], [\"PO105069303\",\"10690524980\"], [\"PO105122458\",\"10690440080\"], [\"PO105121112\",\"10690383260\"], [\"PO105107660\",\"10690525070\"], [\"PO105113207\",\"10690349160\"], [\"PO105113234\",\"10690434456\"], [\"PO105118427\",\"10690493343\"], [\"PO105119173\",\"10690349290\"], [\"PO105118272\",\"10690434587\"], [\"PO105121106\",\"10690349354\"], [\"PO105121200\",\"10690383278\"], [\"PO105094845\",\"10690524999\"], [\"PO105116812\",\"10690493298\"], [\"PO105120858\",\"10690383251\"], [\"PO105099888\",\"10690349119\"], [\"PO105117411\",\"10690434579\"], [\"PO105118450\",\"10690493351\"], [\"PO105120067\",\"10690327755\"], [\"PO105121110\",\"10690434747\"], [\"PO105120656\",\"10690759684\"], [\"PO105127406\",\"10690648310\"], [\"PO105123387\",\"10690782349\"], [\"PO105127265\",\"10690782410\"], [\"PO105125046\",\"10690765048\"], [\"PO105127283\",\"10690681888\"], [\"PO105121757\",\"10690616910\"], [\"PO105122482\",\"10690681781\"], [\"PO105122685\",\"10690689219\"], [\"PO105124049\",\"10690709883\"], [\"PO105119932\",\"10690681730\"], [\"PO105120714\",\"10690681749\"], [\"PO105121650\",\"10690648184\"], [\"PO105123394\",\"10691032565\"], [\"PO105130720\",\"10690897193\"], [\"PO105126913\",\"10690936441\"], [\"PO105118136\",\"10690971941\"], [\"PO105128547\",\"10690944592\"], [\"PO105135063\",\"10691046507\"], [\"PO105127758\",\"10691016867\"], [\"PO105123382\",\"10690936417\"], [\"PO105129752\",\"10690972217\"], [\"PO105126884\",\"10690936433\"], [\"PO105131943\",\"10691279893\"], [\"PO105132060\",\"10691258201\"], [\"PO105128921\",\"10691155063\"], [\"PO105129421\",\"10691218294\"], [\"PO105121861\",\"10691218083\"], [\"PO105128836\",\"10691155047\"], [\"PO105129274\",\"10691155071\"], [\"PO105127596\",\"10691218260\"], [\"PO105130179\",\"10691258121\"], [\"PO105122239\",\"10691218120\"], [\"PO105130284\",\"10691218307\"], [\"PO105131112\",\"10691258164\"], [\"PO105130300\",\"10691482087\"], [\"PO105133536\",\"10691482562\"], [\"PO105134434\",\"10691482685\"], [\"PO105137132\",\"10691395314\"], [\"PO105139971\",\"10691483604\"], [\"PO105116717\",\"10691480627\"], [\"PO105125173\",\"10691481365\"], [\"PO105133225\",\"10691382211\"], [\"PO105134953\",\"10691482757\"], [\"PO105134740\",\"10691395226\"], [\"PO105134149\",\"10691482634\"], [\"PO105138339\",\"10691483233\"], [\"PO105128581\",\"10691481605\"], [\"PO105133587\",\"10691482589\"], [\"PO105138391\",\"10691661214\"], [\"PO105122881\",\"10691661142\"], [\"PO105139253\",\"10691661513\"], [\"PO105139559\",\"10691661530\"], [\"PO105139252\",\"10691661505\"], [\"PO105139560\",\"10691661548\"], [\"PO105139556\",\"10691661521\"], [\"PO105139098\",\"10691661580\"], [\"PO105137104\",\"10691809398\"], [\"PO105138554\",\"10691809478\"], [\"PO105134095\",\"10691809208\"], [\"PO105130259\",\"10692007110\"], [\"PO105130327\",\"10691809048\"], [\"PO105105002\",\"10691666250\"], [\"PO105128042\",\"10691808991\"], [\"PO105135860\",\"10692008220\"], [\"PO105136455\",\"10691715834\"], [\"PO105136615\",\"10691809355\"], [\"PO105139099\",\"10691661599\"], [\"PO105139555\",\"10691661601\"], [\"PO105136632\",\"10691809363\"], [\"PO105135556\",\"10691866569\"], [\"PO105128333\",\"10692006976\"], [\"PO105133535\",\"10691809152\"], [\"PO105132255\",\"10691809080\"], [\"PO105129966\",\"10691715762\"], [\"PO105134302\",\"10692007751\"], [\"PO105123211\",\"10692019112\"], [\"PO105144569\",\"10692021960\"], [\"PO105136081\",\"10692019999\"], [\"PO105139243\",\"10692020712\"], [\"PO105138484\",\"10692020499\"], [\"PO105130107\",\"10692349770\"], [\"PO105147791\",\"10692378336\"], [\"PO105141020\",\"10692378133\"], [\"PO105142858\",\"10692349906\"], [\"PO105130023\",\"10692377956\"], [\"PO105131822\",\"10692509851\"], [\"PO105141567\",\"10692509966\"], [\"PO105144730\",\"10692494836\"], [\"PO105144819\",\"10692335171\"], [\"PO105145369\",\"10692415759\"], [\"PO105144111\",\"10692401942\"], [\"PO105141002\",\"10692451866\"], [\"PO105127188\",\"10692349754\"], [\"PO105141904\",\"10692452027\"], [\"PO105143178\",\"10692335040\"], [\"PO105132993\",\"10692521180\"], [\"PO105144157\",\"10692452043\"], [\"PO105148335\",\"10692378352\"], [\"PO105144596\",\"10692688614\"], [\"PO105149599\",\"10692569014\"], [\"PO105144260\",\"10692688593\"], [\"PO105149612\",\"10692688702\"], [\"PO105145347\",\"10692568925\"], [\"PO105146138\",\"10692688649\"], [\"PO105142125\",\"10692715946\"], [\"PO105145860\",\"10692568941\"], [\"PO105146464\",\"10692568968\"], [\"PO105150379\",\"10692617004\"], [\"PO105144682\",\"10692616827\"], [\"PO105144817\",\"10692568845\"], [\"PO105141105\",\"10692616763\"], [\"PO105147439\",\"10692568976\"], [\"PO105148117\",\"10692977310\"], [\"PO105157294\",\"10692932851\"], [\"PO105147121\",\"10692898416\"], [\"PO105144823\",\"10692977222\"], [\"PO105146955\",\"10692898395\"], [\"PO105149662\",\"10692977847\"], [\"PO105151919\",\"10692932368\"], [\"PO105150335\",\"10692995261\"], [\"PO105144683\",\"10692898344\"], [\"PO105148040\",\"10692995229\"], [\"PO105147695\",\"10692977290\"], [\"PO105148109\",\"10692932202\"], [\"PO105156535\",\"10692932747\"], [\"PO105150770\",\"10693062285\"], [\"PO105152123\",\"10693547930\"], [\"PO105153165\",\"10693548185\"], [\"PO105152401\",\"10693547973\"], [\"PO105156595\",\"10693831378\"], [\"PO105161434\",\"10694001652\"], [\"PO105163543\",\"10693937229\"], [\"PO105158593\",\"10693831440\"], [\"PO105160420\",\"10693845504\"], [\"PO105156586\",\"10693844948\"], [\"PO105166320\",\"10693831554\"], [\"PO105157169\",\"10693845053\"], [\"PO105146402\",\"10693844104\"], [\"PO105156755\",\"10693831386\"], [\"PO105160118\",\"10693845459\"], [\"PO105156459\",\"10693844913\"], [\"PO105161424\",\"10694001644\"], [\"PO105160115\",\"10693845432\"], [\"PO105158361\",\"10694001610\"], [\"PO105160116\",\"10693845440\"], [\"PO105155024\",\"10694120822\"], [\"PO105165121\",\"10694121456\"], [\"PO105141847\",\"10694143100\"], [\"PO105129076\",\"10694143012\"], [\"PO105162906\",\"10694079957\"], [\"PO105164974\",\"10694121430\"], [\"PO105165229\",\"10694121464\"], [\"PO105088547\",\"10694179000\"], [\"PO105161698\",\"10694179595\"], [\"PO105163797\",\"10694179763\"], [\"PO105161980\",\"10694143442\"], [\"PO105164804\",\"10694179835\"], [\"PO105165557\",\"10694121480\"], [\"PO105155761\",\"10694203135\"], [\"PO105156988\",\"10694120902\"], [\"PO105162344\",\"10694179683\"], [\"PO105165235\",\"10694121472\"], [\"PO105163693\",\"10694129962\"], [\"PO105157631\",\"10694203151\"], [\"PO105163737\",\"10694121376\"], [\"PO105163266\",\"10694121368\"], [\"PO105165386\",\"10694143477\"], [\"PO105160388\",\"10694121190\"], [\"PO105086504\",\"10694178996\"], [\"PO105166591\",\"10694459728\"], [\"PO105167048\",\"10694326426\"], [\"PO105169340\",\"10694407418\"], [\"PO105171175\",\"10694377942\"], [\"PO105171176\",\"10694377950\"], [\"PO105166468\",\"10694388245\"], [\"PO105171173\",\"10694383592\"], [\"PO105168015\",\"10694459787\"], [\"PO105160413\",\"10694429164\"], [\"PO105163450\",\"10694477222\"], [\"PO105143488\",\"10694342618\"], [\"PO105096655\",\"10694383007\"], [\"PO105101321\",\"10694342597\"], [\"PO105167518\",\"10694326434\"], [\"PO105171182\",\"10694377969\"], [\"PO105162810\",\"10694508691\"], [\"PO105164465\",\"10694383390\"], [\"PO105164505\",\"10694477265\"], [\"PO105167760\",\"10694383496\"], [\"PO105169288\",\"10694407400\"], [\"PO105166029\",\"10694429404\"], [\"PO105167060\",\"10694383461\"], [\"PO105170935\",\"10694383576\"], [\"PO105162489\",\"10694459592\"], [\"PO105154707\",\"10694459461\"], [\"PO105145828\",\"10694429025\"], [\"PO105166173\",\"10694459701\"], [\"PO105168648\",\"10694326485\"], [\"PO105170263\",\"10694383550\"], [\"PO105172593\",\"10694631138\"], [\"PO105168146\",\"10694631066\"], [\"PO105160744\",\"10694630969\"], [\"4501201529\",\"10680981180\"], [\"4501197636\",\"10680880960\"], [\"4501206116\",\"10684703329\"], [\"4501203683\",\"10684702535\"], [\"4501212945\",\"10689746400\"], [\"4501213971\",\"10689788741\"], [\"4501213123\",\"10689702558\"], [\"4501212012\",\"10689746231\"], [\"4501212591\",\"10689788362\"], [\"4501212779\",\"10689788442\"], [\"4501213072\",\"10689746450\"], [\"4501213135\",\"10689702574\"], [\"4501213867\",\"10689746733\"], [\"4501212681\",\"10689830232\"], [\"4501214125\",\"10689702873\"], [\"4501212340\",\"10689788258\"], [\"4501206781\",\"10689787923\"], [\"4501208352\",\"10689787958\"], [\"4501213331\",\"10689788653\"], [\"4501213999\",\"10689788776\"], [\"4501215511\",\"10689971642\"], [\"4501214464\",\"10689971431\"], [\"4501215227\",\"10689971546\"], [\"4501215892\",\"10690073387\"], [\"4501212278\",\"10690031643\"], [\"4501213448\",\"10690072972\"], [\"4501209564\",\"10690057064\"], [\"4501214475\",\"10689971440\"], [\"4501211529\",\"10690131302\"], [\"4501215731\",\"10690196619\"], [\"4501211240\",\"10690131273\"], [\"4501211247\",\"10690131281\"], [\"4501212640\",\"10690139683\"], [\"4501212791\",\"10690139691\"], [\"4501210983\",\"10690131265\"], [\"4501215446\",\"10690180467\"], [\"4501213502\",\"10690189361\"], [\"4501212129\",\"10690131310\"], [\"4501211506\",\"10690131290\"], [\"4501213904\",\"10690485120\"], [\"4501214156\",\"10690392022\"], [\"4501213577\",\"10690413827\"], [\"4501214021\",\"10690391950\"], [\"4501211004\",\"10690346844\"], [\"4501213882\",\"10690414055\"], [\"4501213594\",\"10690413843\"], [\"4501213572\",\"10690413819\"], [\"4501213874\",\"10690414039\"], [\"4501213934\",\"10690347021\"], [\"4501214200\",\"10690322752\"], [\"4501213277\",\"10690413851\"], [\"4501213686\",\"10690346959\"], [\"4501214192\",\"10690613669\"], [\"4501214436\",\"10690646880\"], [\"4501211932\",\"10690562202\"], [\"4501214429\",\"10690664018\"], [\"4501214713\",\"10690751928\"], [\"4501211219\",\"10690562122\"], [\"4501211486\",\"10690562149\"], [\"4501212622\",\"10690562229\"], [\"4501215428\",\"10690736108\"], [\"4501206429\",\"10690751910\"], [\"4501211196\",\"10690562114\"], [\"4501211919\",\"10690562190\"], [\"4501211958\",\"10690562210\"], [\"4501210355\",\"10690562093\"], [\"4501214564\",\"10690613693\"], [\"4501214731\",\"10690751944\"], [\"4501215498\",\"10690691258\"], [\"4501215767\",\"10690676896\"], [\"4501212646\",\"10690562237\"], [\"4501214758\",\"10690751952\"], [\"4501215512\",\"10690647040\"], [\"4501210349\",\"10690562085\"], [\"4501211503\",\"10690562157\"], [\"4501213992\",\"10690723540\"], [\"4501214254\",\"10690646855\"], [\"4501214554\",\"10690613685\"], [\"4501214573\",\"10690617667\"], [\"4501214733\",\"10690646927\"], [\"4501211370\",\"10690562130\"], [\"4501211523\",\"10690562165\"], [\"4501216050\",\"10690895821\"], [\"4501212490\",\"10690815600\"], [\"4501214469\",\"10690917096\"], [\"4501215857\",\"10690965550\"], [\"4501215861\",\"10690965568\"], [\"4501214466\",\"10690895522\"], [\"4501215021\",\"10691243193\"], [\"4501215058\",\"10691243214\"], [\"4501214636\",\"10691146022\"], [\"4501215737\",\"10691146452\"], [\"4501216176\",\"10691146524\"], [\"4501214905\",\"10691243177\"], [\"4501215308\",\"10691243281\"], [\"4501214764\",\"10691146081\"], [\"4501200767\",\"10691116180\"], [\"4501215046\",\"10691389440\"], [\"4501216712\",\"10691381065\"], [\"4501215578\",\"10691389571\"], [\"4501217198\",\"10691389926\"], [\"4501213307\",\"10691389256\"], [\"4501217146\",\"10691389897\"], [\"4501217071\",\"10691381145\"], [\"4501216575\",\"10691527711\"], [\"4501217108\",\"10691389889\"], [\"4501213603\",\"10689739240\"], [\"4501213878\",\"10690121078\"], [\"4501215609\",\"10690529810\"], [\"4501211504\",\"10690562181\"], [\"4501217033\",\"10690940340\"], [\"4501216193\",\"10690815635\"], [\"4501211505\",\"10691239083\"] ]";
		dataPOnumberInvoicenum = "[ [\"950089632\",\"10662077260\"], [\"950086400\",\"10662077156\"], [\"950089153\",\"10662077244\"], [\"950090755\",\"10662077295\"], [\"950089154\",\"10662077228\"], [\"950086930\",\"10662077164\"], [\"950089159\",\"10662077210\"], [\"950091162\",\"10662077287\"], [\"950090124\",\"10662077279\"], [\"950092782\",\"10662233386\"], [\"950093015\",\"10662233351\"], [\"950099001\",\"10662233482\"], [\"950097047\",\"10662233474\"], [\"950093615\",\"10662233378\"], [\"950093016\",\"10662233360\"], [\"950095494\",\"10662233407\"], [\"950097971\",\"10662233440\"], [\"950100200\",\"10662233503\"], [\"950096545\",\"10662233458\"], [\"950099364\",\"10662233490\"], [\"950093176\",\"10662233394\"], [\"950100332\",\"10662233511\"], [\"950095964\",\"10662233415\"], [\"950095714\",\"10662233423\"] ]";
		dataPOnumberInvoicenum = "[ [\"504086667\",\"10727628222\"], [\"4300987412\",\"10727486543\"], [\"4300987413\",\"10727520153\"], [\"ATU9410\",\"10727877397\"], [\"ATU9404\",\"10727877389\"], [\"ATU9407\",\"10727840282\"], [\"ATU9405\",\"10727840274\"], [\"ATU9409\",\"10727840290\"], [\"ATU9105\",\"10727877362\"], [\"ATU9102\",\"10727880380\"], [\"ATU9103\",\"10727880398\"], [\"ATU9104\",\"10727880371\"], [\"ATU9100\",\"10727877338\"], [\"ATU8508\",\"10727877514\"], [\"ATU8532\",\"10727877522\"], [\"ATU8530\",\"10727877506\"], [\"ATU8867\",\"10727877565\"], [\"ATU8216\",\"10727877485\"], [\"ATU8859\",\"10727877549\"], [\"ATU8868\",\"10727877530\"], [\"ATU8833\",\"10727877290\"], [\"ATU8809\",\"10727877282\"], [\"ATU8836\",\"10727877320\"], [\"ATU8834\",\"10727877311\"], [\"ATU2914\",\"10727888351\"], [\"ATQ8003\",\"10727839475\"], [\"ATU9547\",\"10727880419\"], [\"ATQ1031\",\"10727876560\"], [\"ATQ1580\",\"10727839432\"], [\"ATR6877\",\"10727809661\"], [\"ATU5953\",\"10727877370\"], [\"ATQ5300\",\"10727782222\"], [\"ATQ1182\",\"10727782206\"], [\"ATQ1366\",\"10727782214\"], [\"ATS1226\",\"10727839731\"], [\"ATS5835\",\"10727857666\"], [\"ATR8627\",\"10727809688\"], [\"ATU8829\",\"10727877303\"], [\"ATP9202\",\"10727857316\"], [\"ATP6935\",\"10727877910\"], [\"ATP7022\",\"10727877928\"], [\"ATT4211\",\"10727811078\"], [\"ATR6999\",\"10727809696\"], [\"ATR1816\",\"10727839580\"], [\"ATS1407\",\"10727809733\"], [\"ATU1405\",\"10727840055\"], [\"ATU1536\",\"10727840063\"], [\"ATU3492\",\"10727840207\"], [\"ATT8398\",\"10727839993\"], [\"ATS1269\",\"10727809725\"], [\"ATT3044\",\"10727839942\"], [\"ATU3559\",\"10727840215\"], [\"ATT3402\",\"10727809848\"], [\"ATR1962\",\"10727839598\"], [\"ATU4668\",\"10727877194\"], [\"ATU4717\",\"10727877231\"], [\"ATS8358\",\"10727839838\"], [\"ATS8230\",\"10727839811\"], [\"ATT4528\",\"10727858337\"], [\"ATT1997\",\"10727811035\"], [\"ATT7718\",\"10727811131\"], [\"ATU9611\",\"10727877400\"], [\"ATU9628\",\"10727877434\"], [\"ATU9610\",\"10727877418\"], [\"ATU9667\",\"10727877442\"], [\"ATS4156\",\"10727782281\"], [\"ATS6561\",\"10727876894\"], [\"ATU2488\",\"10727858476\"], [\"ATU1745\",\"10727858417\"], [\"ATS3396\",\"10727876974\"], [\"ATS3394\",\"10727876966\"], [\"ATU6409\",\"10727880400\"], [\"ATR1969\",\"10727839619\"], [\"ATS5685\",\"10727839803\"], [\"ATT7132\",\"10727839934\"], [\"ATT4578\",\"10727811094\"], [\"ATT4528\",\"10727811115\"], [\"ATT4492\",\"10727811086\"], [\"ATT4444\",\"10727811123\"], [\"ATT9611\",\"10727858409\"], [\"ATS4112\",\"10727839740\"], [\"ATU5731\",\"10727877354\"], [\"ATS0556\",\"10727876819\"], [\"ATT1709\",\"10727839846\"], [\"ATQ9717\",\"10727841949\"], [\"ATR7089\",\"10727876712\"], [\"ATR7849\",\"10727876739\"], [\"ATR6342\",\"10727876691\"], [\"ATR7357\",\"10727876720\"], [\"ATP9196\",\"10727876915\"], [\"ATS1123\",\"10727876827\"], [\"ATS1654\",\"10727876835\"], [\"ATS1759\",\"10727876843\"], [\"ATU4572\",\"10727877178\"], [\"ATT1952\",\"10727877987\"], [\"ATT1920\",\"10727877979\"], [\"ATT1978\",\"10727877995\"], [\"ATT1901\",\"10727877952\"], [\"ATT1951\",\"10727877960\"], [\"ATT5687\",\"10727839969\"], [\"ATR5247\",\"10727839678\"], [\"ATR8104\",\"10727839715\"], [\"ATT5327\",\"10727839950\"], [\"ATQ8206\",\"10727839512\"], [\"ATT7940\",\"10727839985\"], [\"ATR4306\",\"10727839635\"], [\"ATR7345\",\"10727839694\"], [\"ATR7776\",\"10727839707\"], [\"ATM4780\",\"10727839651\"], [\"ATR6981\",\"10727839686\"], [\"ATT0187\",\"10727782951\"], [\"ATT0975\",\"10727782960\"], [\"ATS2661\",\"10727809750\"], [\"ATT4243\",\"10727782329\"], [\"ATT4444\",\"10727858345\"], [\"ATT4891\",\"10727858353\"], [\"ATU9654\",\"10727877426\"], [\"16899961\",\"10727878500\"], [\"ATP7962\",\"10727876624\"], [\"ATV6896\",\"10727880435\"], [\"ATT8991\",\"10727858450\"], [\"ATT1709\",\"10727857367\"], [\"ATM4780\",\"10727876683\"], [\"ATR9272\",\"10727876771\"], [\"ATT2186\",\"10727878009\"], [\"ATR1023\",\"10727783382\"], [\"ATT7810\",\"10727880339\"], [\"ATR7783\",\"10727782265\"], [\"4507073331\",\"10727737820\"], [\"ATT8991\",\"10727858468\"], [\"ATN0885\",\"10727881077\"], [\"ATL4223\",\"10727810874\"], [\"ATS4536\",\"10727809768\"], [\"ATM6908\",\"10727881026\"], [\"ATN9674\",\"10727810946\"], [\"ATR0464\",\"10727839547\"], [\"ATN6889\",\"10727881261\"], [\"ATK3158\",\"10727811369\"], [\"ATN0154\",\"10727810090\"], [\"ATN0026\",\"10727810102\"], [\"ATQ3728\",\"10727782230\"], [\"ATE8661\",\"10727840960\"], [\"ATD0412\",\"10727809928\"], [\"ATD0415\",\"10727809952\"], [\"ATE8498\",\"10727809960\"], [\"ATD0414\",\"10727809936\"], [\"ATE8497\",\"10727809987\"], [\"ATE8536\",\"10727809995\"], [\"ATI5722\",\"10727810014\"], [\"ATD0413\",\"10727809944\"], [\"ATI1535\",\"10727810006\"], [\"ATE8501\",\"10727809979\"], [\"ATI5725\",\"10727810022\"], [\"ATT6216\",\"10727880582\"], [\"ATU4414\",\"10727858441\"], [\"ATS2835\",\"10727782302\"], [\"ATK3810\",\"10727811406\"], [\"ATJ5851\",\"10727857228\"], [\"ATJ5849\",\"10727857210\"], [\"ATG9843\",\"10727839070\"], [\"ATJ0974\",\"10727841818\"], [\"ATJ1804\",\"10727858089\"], [\"ATE1621\",\"10727840370\"], [\"ATE1619\",\"10727840389\"], [\"ATD8140\",\"10727840397\"], [\"ATK7033\",\"10727840442\"], [\"ATR3354\",\"10727858265\"], [\"ATM4771\",\"10727880224\"], [\"ATH3874\",\"10727810760\"], [\"ATE8687\",\"10727840979\"], [\"ATL3758\",\"10727880208\"], [\"ATE3112\",\"10727809186\"], [\"ATC4588\",\"10727809071\"], [\"ASI6834\",\"10727810399\"], [\"ATE3106\",\"10727809178\"], [\"ATD0679\",\"10727809135\"], [\"ATE3115\",\"10727809194\"], [\"ASV8197\",\"10727856696\"], [\"ASW3926\",\"10727856717\"], [\"ASW3931\",\"10727856709\"], [\"ATJ6326\",\"10727809397\"], [\"ATJ6617\",\"10727857236\"], [\"ATJ6632\",\"10727839192\"], [\"ATK7350\",\"10727876448\"], [\"ATD6927\",\"10727841738\"], [\"ATG6277\",\"10727810751\"], [\"ATI1888\",\"10727858118\"], [\"ATM4325\",\"10727858193\"], [\"ATM4319\",\"10727858185\"], [\"ATM3188\",\"10727876528\"], [\"ATK7124\",\"10727876413\"], [\"ATL9672\",\"10727858740\"], [\"ATM0200\",\"10727809485\"], [\"ATE5960\",\"10727840944\"], [\"ATE5958\",\"10727840936\"], [\"ATL4550\",\"10727858732\"], [\"ATD8829\",\"10727840928\"], [\"ATD9930\",\"10727858020\"], [\"ATE0957\",\"10727858011\"], [\"ATK4048\",\"10727809493\"], [\"ASZ0183\",\"10727809047\"], [\"ATD0687\",\"10727809127\"], [\"ATE0959\",\"10727809143\"], [\"ATD0726\",\"10727857017\"], [\"ATD8237\",\"10727838980\"], [\"ASX7865\",\"10727810225\"], [\"ATR7711\",\"10727839766\"], [\"ATH1197\",\"10727857113\"], [\"ATA5006\",\"10727838892\"], [\"ATK7317\",\"10727811377\"], [\"ATA3499\",\"10727838964\"], [\"ATS1601\",\"10727858281\"], [\"ATI7273\",\"10727857172\"], [\"ASZ0163\",\"10727880144\"], [\"ATG4752\",\"10727858660\"], [\"ATJ6679\",\"10727876333\"], [\"ATJ6706\",\"10727880160\"], [\"ATJ6677\",\"10727880179\"], [\"ATN9993\",\"10727880566\"], [\"ATN7912\",\"10727881270\"], [\"ATA5274\",\"10727857973\"], [\"ATK9714\",\"10727858759\"], [\"ATC3297\",\"10727810241\"], [\"ATJ6599\",\"10727880195\"], [\"ATJ6602\",\"10727880187\"], [\"ATM9991\",\"10727881034\"], [\"ATU4684\",\"10727857869\"], [\"ATG5426\",\"10727857121\"], [\"ATC4581\",\"10727856813\"], [\"ATB8376\",\"10727838059\"], [\"ATB7902\",\"10727856805\"], [\"ATS3973\",\"10727876907\"], [\"ATV4683\",\"10727840320\"], [\"ASX8917\",\"10727857949\"], [\"ATR9100\",\"10727876798\"], [\"ATE2545\",\"10727811297\"], [\"ATN9192\",\"10727880742\"], [\"ATN9193\",\"10727808309\"], [\"ATL0194\",\"10727810065\"], [\"ATC4586\",\"10727856821\"], [\"4507073331\",\"10727759509\"], [\"4507073331\",\"10727759517\"], [\"ATW0406\",\"10727880443\"], [\"2153350C\",\"10727663482\"], [\"ATH1319\",\"10727841017\"], [\"ATF6834\",\"10727809223\"], [\"ATN9194\",\"10727881157\"], [\"ASU3599\",\"10727857914\"], [\"ATC2494\",\"10727811262\"], [\"ATJ8256\",\"10727781789\"], [\"ASY7902\",\"10727856741\"], [\"ATD4893\",\"10727810727\"], [\"ATL1203\",\"10727881018\"], [\"ATR0464\",\"10727809581\"], [\"ATN0885\",\"10727858222\"], [\"ASY3825\",\"10727809004\"], [\"ATH5890\",\"10727782775\"], [\"ATN9194\",\"10727881114\"], [\"ATN9194\",\"10727881085\"], [\"ATN9194\",\"10727881130\"], [\"ATN9194\",\"10727881122\"], [\"ATN9194\",\"10727881093\"], [\"ATN9194\",\"10727881106\"], [\"ATN9194\",\"10727881149\"], [\"4507073429\",\"10727839344\"], [\"ATP2085\",\"10727880312\"], [\"ATE3114\",\"10727857041\"], [\"ASY0287\",\"10727858580\"], [\"ATE2545\",\"10727811289\"], [\"GP01217115\",\"10727804554\"], [\"ATE0780\",\"10727809151\"], [\"ATM7860\",\"10727881245\"], [\"ATN0885\",\"10727881069\"], [\"ATN6828\",\"10727782943\"], [\"ATE9994\",\"10727881000\"], [\"GP01217115\",\"10727882573\"], [\"ATB1808\",\"10727857981\"], [\"ATM5696\",\"10727880259\"], [\"4507073331\",\"10727737838\"], [\"ATV0406\",\"10727877450\"], [\"4507073331\",\"10727701605\"] ]";
		dataPOnumberInvoicenum = "[[\"68529017\",\"10752240308\"]]\r\n"
				+ "";
		
		JSONArray dataJson = new JSONArray(dataPOnumberInvoicenum);
		new CorrectSoldToRetrigger().correctSoldTo(dataJson);
	}
	
	public void correctSoldTo(JSONArray dataJson) {
		JSONArray dataJsonRetrigger = new JSONArray(); 
		restutil.VERITAS_INTERNAL_AUTH_KEY = "D8D2AD87-3329-4D80-8EC7-84E112A48785";
		for(int i=0;i<dataJson.length();i++) {
			String ponum = dataJson.getJSONArray(i).getString(0);
			String invnum = dataJson.getJSONArray(i).getString(1);
			
			try {
				JSONArray cfo_all_data = new JSONArray(restutil.sendGetRequest(MongoService_prod + "getCFODocByInv?invNo="+invnum));
				
				JSONObject cfo_data;
				if(cfo_all_data.length() > 0) {
					cfo_data = cfo_all_data.getJSONObject(0);
//					System.out.println(cfo_data);
					String DocID = cfo_data.getString("DocID");
					Object SoldTo = cfo_data.getJSONObject("Request").getJSONObject("InvoiceRequest")
					.getJSONObject("InvoiceRequestHeader")
					.getJSONArray("InvoicePartner")
					.getJSONObject(0)
					.getJSONObject("address_type")
					.get("SoldTo");
					if(SoldTo instanceof JSONObject) {
						System.out.println("JSONObject");
						JSONArray soldetoarray = new JSONArray();
						soldetoarray.put(new JSONObject(SoldTo.toString()));
						SoldTo = soldetoarray;
						 cfo_data.getJSONObject("Request").getJSONObject("InvoiceRequest")
							.getJSONObject("InvoiceRequestHeader")
							.getJSONArray("InvoicePartner")
							.getJSONObject(0)
							.getJSONObject("address_type")
							.put("SoldTo", soldetoarray);
						 System.out.println("-----");
//						 System.out.println(cfo_data);
							
						 String respDelcce = restutil.sendPostRequest(MongoService_prod + "upsertCFODataDocID?docid="+DocID, cfo_data.toString());
							
						 System.out.println("successfull -> " + i + "----"+invnum+" --- " + DocID + " -- "+ ponum +" -->  " + respDelcce);
						 
						 JSONArray one_po_inv_data = new JSONArray();
						 one_po_inv_data.put(ponum);
						 one_po_inv_data.put(invnum);
						 dataJsonRetrigger.put(one_po_inv_data);
					} else if(SoldTo instanceof JSONArray) {
						System.out.println("JSONArray");
					}
					
					
				}
				else {
					System.out.println("no data present -> " + i + "----"+invnum+" --- "+ ponum +" -->  ");
				}
				
				
//				String dpid = inv_data.getString("DPID");
//				System.out.println(cfo_data);
//				String request = "{\r\n" + 
//						"    \"dpid\": \""+dpid+"\",\r\n" + 
//						"    \"PONumber\": \""+ponum+"\",\r\n" + 
//						"    \"invoice_list\": [\r\n" + 
//						"        {\r\n" + 
//						"            \"trx_number\": \""+invnum+"\",\r\n" + 
//						"            \"ReasonCode\": \"Export Ready\"\r\n" + 
//						"        }\r\n" + 
//						"    ]\r\n" + 
//						"}";
				
//				String respDelcce = restutil.sendPostRequest(deliverToCCETriggerEvent_prod, request);
//				System.out.println(i + "----"+invnum+" --- "+ ponum +" -->  ");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		new RetriggerDeliverToCCE().retriggerDeliverToCCE(dataJsonRetrigger);
	}
}
