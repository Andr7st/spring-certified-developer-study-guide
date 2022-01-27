package io.davidarchanjo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.ToString;

interface Drivable {
}

@Component
class Bmw implements Drivable {
}

@Component
class Mercedes implements Drivable {
}

@ToString
@AllArgsConstructor
public class Driver {
    private Drivable drivable;
}