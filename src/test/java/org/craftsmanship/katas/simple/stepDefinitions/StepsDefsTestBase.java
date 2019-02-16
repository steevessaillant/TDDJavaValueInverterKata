package org.craftsmanship.katas.simple.stepDefinitions;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@SpringBootTest(classes = StepsDefsTestBase.class)
@Configuration
@ComponentScan(basePackages = { "org.craftsmanship.katas.simple.stepDefinitions" })
public abstract class StepsDefsTestBase extends SpringBootTestContextBootstrapper {

}

