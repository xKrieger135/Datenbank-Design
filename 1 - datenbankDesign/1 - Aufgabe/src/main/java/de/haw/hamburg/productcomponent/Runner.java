/*
 * This file is part of a Werum IT Solutions GmbH project.
 *
 * Copyright (c)
 *    Werum IT Solutions GmbH
 *    All rights reserved.
 *
 * This source file may be managed in different Java package structures,
 * depending on actual usage of the source file by the Copyright holders:
 *
 * for Werum:  com.werum.* or any other Werum owned Internet domain
 *
 * Any use of this file as part of a software system by none Copyright holders
 * is subject to license terms.
 *
 * Last Change: $Id: $$
 */
package de.haw.hamburg.productcomponent;

import de.haw.hamburg.productcomponent.accesslayer.view.MainFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Description...
 *
 * @author patrick_steinhauer
 * @company Werum IT Solutions GmbH
 * @created 21.11.2016
 * @since PAS-X V3.2.1
 */
@Component
public class Runner implements CommandLineRunner{
    @Autowired
    private MainFrame mainFrame;

    @Override
    public void run(String... args) throws Exception {
        mainFrame.showView();
    }
}
